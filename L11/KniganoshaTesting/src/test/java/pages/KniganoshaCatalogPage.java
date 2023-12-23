package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KniganoshaCatalogPage extends AbstractPage {
        public static final String CATALOG_PAGE_URL = "https://kniganosha.by/catalog";

        @FindBy(css = ".addBasket:first-of-type")
        private WebElement firstAddItemToCartButton;

        public KniganoshaCatalogPage(WebDriver driver) {
                super(driver);
                PageFactory.initElements(this.driver, this);
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
}
