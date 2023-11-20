package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KniganoshaCartPage extends AbstractPage{
        public static final String CART_PAGE_URL = "https://kniganosha.by/basket";

        @FindBy(xpath = "//div[@class='del btn redH'][1]")
        private WebElement removeFirstItemFromCartButton;

        @FindBy(xpath = "//div[@class='basketItem']")
        private List<WebElement> cartItems;

        public KniganoshaCartPage(WebDriver driver) {
                super(driver);
        }

        @Override
        public KniganoshaCartPage openPage() {
                return (KniganoshaCartPage) openPage(CART_PAGE_URL);
        }

        public KniganoshaCartPage removeFirstItemFromCart() {
                removeFirstItemFromCartButton.click();
                return this;
        }

        public int countItemsInCart() {
                return cartItems.size();
        }
}