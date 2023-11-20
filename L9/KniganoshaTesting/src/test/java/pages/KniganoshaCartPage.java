package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class KniganoshaCartPage extends AbstractPage{
        public static final String CART_PAGE_URL = "https://kniganosha.by/basket";

        @FindBy(xpath = "/html/body/main/div[2]/div/div[2]/div[1]/div/div[4]")
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