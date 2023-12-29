package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.KniganoshaCartPage;
import pages.KniganoshaCatalogPage;


public class KniganoshaCatalogTests extends CommonConditions {
    @Test(description = "Test #1: filter by discount")
    public void givenCatalogOpened_whenOnlyWithDiscountClicked_thenFilterCatalogByDiscount() {
        var catalogPage = new KniganoshaCatalogPage(driver)
                .openPage()
                .fiterByDiscount();
        Assert.assertEquals(catalogPage.getItemsCount(), catalogPage.getOldPricesCount(), "Not all items have old prices.");
    }

    @Test(description = "Test #2: filter by availability")
    public void givenCatalogOpened_whenOnlyInStockClicked_thenFilterCatalogByAvailability() {
        var catalogPage = new KniganoshaCatalogPage(driver)
                .openPage()
                .filterByAvailability();
        Assert.assertEquals(catalogPage.getNotInStockCount(), 0, "Not all items are available.");
    }
}