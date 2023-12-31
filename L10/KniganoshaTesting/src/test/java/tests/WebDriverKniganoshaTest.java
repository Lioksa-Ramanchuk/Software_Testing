package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KniganoshaCartPage;
import pages.KniganoshaCatalogPage;


public class WebDriverKniganoshaTest {
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Test #6: removing item from cart by 'x' button click")
    public void givenItemAddedToCart_whenRemoveButtonClicked_thenItemRemovedFromCart() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        int cartItemsCount = new KniganoshaCartPage(driver)
                .openPage()
                .removeFirstItemFromCart()
                .countItemsInCart();

        Assert.assertEquals(cartItemsCount, 0, "Cart needs to be empty.");
    }



    @Test(description = "Test #7: checking upper bound of item count in cart")
    public void givenItemAddedToCart_whenItemCountUpperBoundExceeded_thenItemCountIsResetTo1() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        double firstCartItemCount = new KniganoshaCartPage(driver)
                .openPage()
                .setFirstItemCountTo(999999999999999L)
                .getFirstItemCount();

        Assert.assertEquals(firstCartItemCount, 1L, "Cart item count wasn't reset to 1.");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}