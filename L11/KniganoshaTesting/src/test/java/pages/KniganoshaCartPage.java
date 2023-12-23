package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KniganoshaCartPage extends AbstractPage{
        public static final String CART_PAGE_URL = "https://kniganosha.by/basket";
        private final Logger logger = LogManager.getRootLogger();

        @FindBy(css = ".basketItem > .del")
        private WebElement removeFirstItemFromCartButton;
        @FindBy(xpath = "/html/body/main/div[2]/div/div[2]/div[1]/div/div[3]/input")
        private WebElement firstItemCountInput;
        @FindBy(css = ".basketItem")
        private List<WebElement> cartItems;

        public KniganoshaCartPage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(this.driver, this);
        }

        @Override
        public KniganoshaCartPage openPage() {
                return (KniganoshaCartPage) openPage(CART_PAGE_URL);
        }

        public KniganoshaCartPage removeFirstItemFromCart() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(removeFirstItemFromCartButton));
                removeFirstItemFromCartButton.click();
                logger.info("Removed 1st item from cart.");
                return this;
        }

        public KniganoshaCartPage setFirstItemCountTo(long newCount) {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.visibilityOf(firstItemCountInput));
                firstItemCountInput.clear();
                firstItemCountInput.sendKeys(Long.toString(newCount));
                return this;
        }

        public int countItemsInCart() {
                return cartItems.size();
        }
        public long getFirstItemCount() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.visibilityOf(firstItemCountInput));
                return Long.parseUnsignedLong(firstItemCountInput.getAttribute("value"));
        }
}