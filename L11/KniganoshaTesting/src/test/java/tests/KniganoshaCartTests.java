package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KniganoshaCartPage;
import pages.KniganoshaCatalogPage;


public class KniganoshaCartTests extends CommonConditions {
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
                .setFirstItemCountTo(999999999999999L)
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
                .setFirstItemCountTo("A")
                .getFirstItemCount();

        Assert.assertEquals(firstCartItemCount, 1L, "Cart item count wasn't reset to 1.");
    }
}