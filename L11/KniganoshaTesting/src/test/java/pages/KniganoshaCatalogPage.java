package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KniganoshaCatalogPage extends AbstractPage {
        public static final String CATALOG_PAGE_URL = "https://kniganosha.by/catalog";

        @FindBy(css = ".addBasket:first-of-type")
        private WebElement firstAddItemToCartButton;

        @FindBy(css = "#stockCheck")
        private WebElement onlyWithDiscountCheckbox;

        @FindBy(css = ".panel-tovar span.old")
        private List<WebElement> oldPrices;

        @FindBy(css = ".panel-tovar")
        private List<WebElement> items;

        public KniganoshaCatalogPage(WebDriver driver) {
                super(driver);
        }

        @Override
        public KniganoshaCatalogPage openPage() {
                return (KniganoshaCatalogPage) openPage(CATALOG_PAGE_URL);
        }

        public KniganoshaCatalogPage addFirstAvailableItemToCart() {
                new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                        .until(ExpectedConditions.elementToBeClickable(firstAddItemToCartButton));
                firstAddItemToCartButton.click();
                return this;
        }

        public KniganoshaCatalogPage fiterByDiscount() {
                // WebDriverWait doesn't work on onlyWithDiscountCheckbox here :( But the element works correctly :)
                if (!onlyWithDiscountCheckbox.isSelected()) {
                        onlyWithDiscountCheckbox.click();
                }
                return this;
        }

        public int getItemsCount() {
                return items.size();
        }

        public int getOldPricesCount() {
                return oldPrices.size();
        }
}
