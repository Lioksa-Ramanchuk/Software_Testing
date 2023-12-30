package pages;

import model.DT3OrderingForm;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static utils.CoreUtils.coalesce;

public class KniganoshaCartPage extends AbstractPage {
        public static final String CART_PAGE_URL = "https://kniganosha.by/basket";

        public KniganoshaCartPage(WebDriver driver) {
                super(driver);
        }
        @Override
        public KniganoshaCartPage openPage() {
                return (KniganoshaCartPage) openPage(CART_PAGE_URL);
        }

        // CART LEVEL 1
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
        @FindBy(css = "#checkout")
        private WebElement goToLayer2Button;
        @FindBy(css = ".basketItem")
        private List<WebElement> cartItems;

        public KniganoshaCartPage removeFirstItemFromCart() {
                clickWhenClickable(removeFirstItemFromCartButton);
                logger.info("Removed 1st item from cart.");
                return this;
        }
        public KniganoshaCartPage setFirstItemCountTo(String newCountStr) {
                sendKeysWhenVisible(firstItemCountInput, newCountStr);
                logger.info("Set 1st item count to \""+newCountStr+"\".");
                return this;
        }
        public KniganoshaCartPage incrementFirstItemCount() {
                clickWhenClickable(incrementFirstItemCountButton);
                logger.info("Incremented 1st item count.");
                return this;
        }
        public KniganoshaCartPage decrementFirstItemCount() {
                clickWhenClickable(decrementFirstItemCountButton);
                logger.info("Decremented 1st item count.");
                return this;
        }
        public KniganoshaCartPage goToLayer2() {
                clickWhenClickable(goToLayer2Button);
                logger.info("Proceeded to cart level 2.");
                return this;
        }
        public int getCartItemsCount() {
                return cartItems.size();
        }
        public long getFirstItemCount() {
                waitUntilVisibilityOf(firstItemCountInput);
                return Long.parseUnsignedLong(firstItemCountInput.getAttribute("value"));
        }
        public double getCartCost() {
                waitUntilVisibilityOf(cartCost);
                return Double.parseDouble(cartCost.getText());
        }

        // CART LAYER 2
        @FindBy(css = "#basketDeliveryType")
        private WebElement cartDeliveryTypeButton;
        @FindBy(css = "#basketName")
        private WebElement nameInput;
        @FindBy(css = "#basketPatronymic")
        private WebElement patronymicInput;
        @FindBy(css = "#basketSurname")
        private WebElement surnameInput;
        @FindBy(css = "#basketPhone")
        private WebElement phoneInput;
        @FindBy(css = "#basketEmail")
        private WebElement emailInput;
        @FindBy(css = "#basketCity")
        private WebElement cityInput;
        @FindBy(css = "#basketIndex")
        private WebElement postIndexInput;
        @FindBy(css = "#basketStreet")
        private WebElement streetInput;
        @FindBy(css = "#basketHouse")
        private WebElement houseInput;
        @FindBy(css = "#basketHousing")
        private WebElement corpusInput;
        @FindBy(css = "#basketApartment")
        private WebElement apartmentInput;
        @FindBy(css = "#basketMess")
        private WebElement additionalInput;
        @FindBy(css = "#сheck") // Yes, with *cyrillic* 'с'...
        private WebElement goToLayer3Button;

        public KniganoshaCartPage goToLayer3() {
                clickWhenClickable(goToLayer3Button);
                logger.info("Proceeded to cart level 3.");
                return this;
        }
        public KniganoshaCartPage setDeliveryType(String deliveryType) {
                clickWhenClickable(cartDeliveryTypeButton);
                clickWhenClickable(By.id(deliveryType));
                logger.info("Set delivery type "+deliveryType+".");
                return this;
        }
        public KniganoshaCartPage fillOrderingFormWith(DT3OrderingForm form) {
                sendKeysWhenVisible(nameInput, form.getName());
                sendKeysWhenVisible(patronymicInput, form.getPatronymic());
                sendKeysWhenVisible(surnameInput, form.getSurname());
                sendKeysWhenVisible(phoneInput, form.getPhone());
                sendKeysWhenVisible(emailInput, form.getEmail());
                sendKeysWhenVisible(cityInput, form.getCity());
                sendKeysWhenVisible(postIndexInput, coalesce(form.getPostIndex(), ""));
                sendKeysWhenVisible(streetInput, form.getStreet());
                sendKeysWhenVisible(houseInput, form.getHouse());
                sendKeysWhenVisible(corpusInput, coalesce(form.getCorpus(), ""));
                sendKeysWhenVisible(apartmentInput, coalesce(form.getApartment(), ""));
                sendKeysWhenVisible(additionalInput, coalesce(form.getAdditional(), ""));
                logger.info("Filled DT3 ordering form.");
                return this;
        }

        // CART LAYER 3
        @FindBy(css = "#payment-end")
        private WebElement goToPaymentEndButton;
        public boolean proceededToLayer3() {
                try {
                        new WebDriverWait(driver, 3)
                                .until(ExpectedConditions.elementToBeClickable(goToPaymentEndButton));
                } catch (Exception e) {
                        return false;
                }
                return true;
        }
}