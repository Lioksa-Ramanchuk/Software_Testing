package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(BrowserType browserType) {
        if (null == driver) {
            switch (browserType) {
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case CHROME -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                default -> throw new RuntimeException("Unknown browser: " + browserType);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

