package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CustomConditions;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final long WAIT_TIMEOUT_DURATION = 30;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected AbstractPage openPage(String url) {
        driver.get(url);
        new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
}
