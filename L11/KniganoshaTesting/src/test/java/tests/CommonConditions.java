package tests;

import driver.BrowserType;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver(BrowserType.FIREFOX);
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() { DriverSingleton.closeDriver(); }
}
