package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KniganoshaCatalogPage extends AbstractPage {
        public static final String CATALOG_PAGE_URL = "https://kniganosha.by/catalog";

        @FindBy(css = ".addBasket:first-of-type")
        private WebElement firstAddItemToCartButton;
        @FindBy(css = "#stockCheck")    // No mistype here :/
        private WebElement onlyWithDiscountCheckbox;
        @FindBy(css = "#not_a")
        private WebElement onlyInStockCheckbox;
        @FindBy(css = "#genresBtn")
        private WebElement genresButton;
        @FindBy(css = ".panel-tovar span.old")
        private List<WebElement> oldPrices;
        @FindBy(css = ".panel-tovar")
        private List<WebElement> items;
        @FindBy(css = "span.none")
        private List<WebElement> notInStock;

        public KniganoshaCatalogPage(WebDriver driver) {
                super(driver);
        }

        @Override
        public KniganoshaCatalogPage openPage() {
                return (KniganoshaCatalogPage) openPage(CATALOG_PAGE_URL);
        }

        public KniganoshaCatalogPage addFirstAvailableItemToCart() {
                clickWhenClickable(firstAddItemToCartButton);
                logger.info("Added 1st available item to cart.");
                return this;
        }
        public KniganoshaCatalogPage filterByDiscount() {
                // WebDriverWait doesn't work on onlyWithDiscountCheckbox here :( But the element works correctly :)
                if (!onlyWithDiscountCheckbox.isSelected()) {
                        onlyWithDiscountCheckbox.click();
                }
                logger.info("Filtered catalog by discount.");
                return this;
        }
        public KniganoshaCatalogPage filterByAvailability() {
                // WebDriverWait doesn't work on onlyInStockCheckbox here :( But the element works correctly :)
                if (!onlyInStockCheckbox.isSelected()) {
                        onlyInStockCheckbox.click();
                }
                logger.info("Filtered catalog by availability.");
                return this;
        }
        public KniganoshaCatalogPage filterByGenre(String genre) {
                clickWhenClickable(genresButton);
                clickWhenClickable(By.id(genre));
                logger.info("Filtered catalog by genre.");
                return this;
        }

        public int getItemsCount() {
                return items.size();
        }
        public int getOldPricesCount() {
                return oldPrices.size();
        }
        public int getNotInStockCount() {
                return notInStock.size();
        }
        public int getItemsByGenreCount(String genre) {
                return driver.findElements(By.cssSelector("a[href^=\"/catalog/"+genre+"/\"]")).size();
        }
}
