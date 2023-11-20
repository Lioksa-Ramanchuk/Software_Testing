package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class KniganoshaCatalogPage extends AbstractPage {
        public static final String CATALOG_PAGE_URL = "https://kniganosha.by/catalog";
        private static final String TO_CART_TOGGLE_BUTTON_TEXT = "У кошык";

        @FindBy(id = "not_a")
        private WebElement onlyInStockFilterCheckBox;

        @FindBy(xpath = "/html/body/main/div[2]/div/div[2]/div[2]/div[1]/div/button")
        private WebElement firstItemInCartToggleButton;

        public KniganoshaCatalogPage(WebDriver driver) {
                super(driver);
        }

        @Override
        public KniganoshaCatalogPage openPage() {
                return (KniganoshaCatalogPage) openPage(CATALOG_PAGE_URL);
        }
        public KniganoshaCatalogPage addFirstAvailableItemToCart() {
                onlyInStockFilterCheckBox.click();
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(firstItemInCartToggleButton));
                if (Objects.equals(firstItemInCartToggleButton.getText(), TO_CART_TOGGLE_BUTTON_TEXT)) {
                        firstItemInCartToggleButton.click();
                }
                onlyInStockFilterCheckBox.click();
                return this;
        }
}
