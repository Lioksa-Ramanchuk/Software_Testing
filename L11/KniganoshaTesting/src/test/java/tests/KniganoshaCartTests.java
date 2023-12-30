package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KniganoshaCartPage;
import pages.KniganoshaCatalogPage;
import service.DT3OrderingFormCreator;
import service.TestDataReader;


public class KniganoshaCartTests extends PageTestsBase {
    @Test(description = "Test #4: cart cost updates on item count change")
    public void givenItemAddedToCart_whenItemCountIncremented_thenCartCostChanges() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        var cartPage = new KniganoshaCartPage(driver)
                .openPage();
        var cartCostBefore = cartPage.getCartCost();
        cartPage.incrementFirstItemCount();
        var cartCostAfter = cartPage.getCartCost();

        Assert.assertNotEquals(cartCostBefore, cartCostAfter, "Cart cost didn't change.");
    }
    @Test(description = "Test #5: item is removed from cart on decrementing count of 1")
    public void givenItemAddedToCartWithCountOfOne_whenItemCountDecremented_thenItemIsRemovedFromCart() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        var cartPage = new KniganoshaCartPage(driver)
                .openPage();
        var cartItemsCountBefore = cartPage.getCartItemsCount();
        cartPage.decrementFirstItemCount();
        var cartItemsCountAfter = cartPage.getCartItemsCount();

        Assert.assertNotEquals(cartItemsCountBefore, cartItemsCountAfter, "Item was not removed from cart.");
    }
    @Test(description = "Test #6: removing item from cart by 'x' button click")
    public void givenItemAddedToCart_whenRemoveButtonClicked_thenItemRemovedFromCart() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        int cartItemsCount = new KniganoshaCartPage(driver)
                .openPage()
                .removeFirstItemFromCart()
                .getCartItemsCount();

        Assert.assertEquals(cartItemsCount, 0, "Cart needs to be empty.");
    }
    @Test(description = "Test #7: checking upper bound of item count in cart")
    public void givenItemAddedToCart_whenItemCountUpperBoundExceeded_thenItemCountIsResetTo1() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        long firstCartItemCount = new KniganoshaCartPage(driver)
                .openPage()
                .setFirstItemCountTo(TestDataReader.getTestDataLocal("t7_big_item_count"))
                .getFirstItemCount();

        Assert.assertEquals(firstCartItemCount, 1L, "Cart item count wasn't reset to 1.");
    }
    @Test(description = "Test #8: checking text input unavailability in cart item count input field")
    public void givenItemAddedToCart_whenTextInputtedIntoItemCount_thenItemCountIsResetTo1() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        long firstCartItemCount = new KniganoshaCartPage(driver)
                .openPage()
                .setFirstItemCountTo(TestDataReader.getTestDataLocal("t8_text_for_count"))
                .getFirstItemCount();

        Assert.assertEquals(firstCartItemCount, 1L, "Cart item count wasn't reset to 1.");
    }
    @Test(description = "Test #9: checking city name length lower bound when ordering (dt3)")
    public void givenItemAddedToCart_whenOrderingAndCityHasLengthOfTwo_thenCityIsValid() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        final String deliveryType = TestDataReader.getTestDataLocal("t9_delivery_type");
        var proceededToLayer3 = new KniganoshaCartPage(driver)
                .openPage()
                .goToLayer2()
                .setDeliveryType(deliveryType)
                .fillOrderingFormWith(DT3OrderingFormCreator.createWithCity(TestDataReader.getTestDataLocal("t9_valid_city")))
                .goToLayer3()
                .proceededToLayer3();

        Assert.assertTrue(proceededToLayer3, "Didn't proceed to cart level 3 (city is invalid).");
    }
    @Test(description = "Test #10: checking street length upper bound when ordering (dt3)")
    public void givenItemAddedToCart_whenOrderingAndStreetHasLongLength_thenStreetIsInvalid() {
        new KniganoshaCatalogPage(driver)
                .openPage()
                .addFirstAvailableItemToCart();
        final String deliveryType = TestDataReader.getTestDataLocal("t10_delivery_type");
        var proceededToLayer3 = new KniganoshaCartPage(driver)
                .openPage()
                .goToLayer2()
                .setDeliveryType(deliveryType)
                .fillOrderingFormWith(DT3OrderingFormCreator.createWithStreet(TestDataReader.getTestDataLocal("t10_long_street")))
                .goToLayer3()
                .proceededToLayer3();

        Assert.assertFalse(proceededToLayer3, "Proceeded to cart level 3 (street is valid).");
    }
}