package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KniganoshaCartPage extends AbstractPage{
        public static final String CART_PAGE_URL = "https://kniganosha.by/basket";

        @FindBy(css = ".basketItem .count .plusT")
        private WebElement incrementFirstItemCountButton;
        @FindBy(css = ".basketItem > .del")
        private WebElement removeFirstItemFromCartButton;
        @FindBy(css = ".basketItem .count .minusT")
        private WebElement decrementFirstItemCountButton;
        @FindBy(xpath = "/html/body/main/div[2]/div/div[2]/div[1]/div/div[3]/input")
        private WebElement firstItemCountInput;
        @FindBy(css = ".total > span")
        private WebElement cartCost;
        @FindBy(css = ".basketItem")
        private List<WebElement> cartItems;

        public KniganoshaCartPage(WebDriver driver) {
                super(driver);
        }

        @Override
        public KniganoshaCartPage openPage() {
                return (KniganoshaCartPage) openPage(CART_PAGE_URL);
        }

        public KniganoshaCartPage removeFirstItemFromCart() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(removeFirstItemFromCartButton))
                        .click();
                logger.info("Removed 1st item from cart.");
                return this;
        }

        public KniganoshaCartPage setFirstItemCountTo(long newCount) {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.visibilityOf(firstItemCountInput));
                firstItemCountInput.clear();
                firstItemCountInput.sendKeys(Long.toString(newCount));
                logger.info("Set 1st item count to "+newCount+".");
                return this;
        }
        public KniganoshaCartPage setFirstItemCountTo(String newCountStr) {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.visibilityOf(firstItemCountInput));
                firstItemCountInput.clear();
                firstItemCountInput.sendKeys(newCountStr);
                logger.info("Set 1st item count to \""+newCountStr+"\".");
                return this;
        }
        public KniganoshaCartPage incrementFirstItemCount() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(incrementFirstItemCountButton))
                        .click();
                logger.info("Incremented 1st item count.");
                return this;
        }
        public KniganoshaCartPage decrementFirstItemCount() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(decrementFirstItemCountButton))
                        .click();
                logger.info("Decremented 1st item count.");
                return this;
        }

        public int getCartItemsCount() {
                return cartItems.size();
        }
        public long getFirstItemCount() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.visibilityOf(firstItemCountInput));
                return Long.parseUnsignedLong(firstItemCountInput.getAttribute("value"));
        }
        public double getCartCost() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.visibilityOf(cartCost));
                return Double.parseDouble(cartCost.getText());
        }
}