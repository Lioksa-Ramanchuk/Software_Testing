package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CustomConditions;

public abstract class AbstractPage {
    protected final Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final long WAIT_TIMEOUT_DURATION = 20;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected AbstractPage openPage(String url) {
        driver.get(url);
        new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }
}
