package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KniganoshaCatalogPage;
import service.TestDataReader;


public class KniganoshaCatalogTests extends PageTestsBase {
    @Test(description = "Test #1: filter by discount")
    public void givenCatalogOpened_whenOnlyWithDiscountClicked_thenFilterCatalogByDiscount() {
        var catalogPage = new KniganoshaCatalogPage(driver)
                .openPage()
                .filterByDiscount();
        Assert.assertEquals(catalogPage.getItemsCount(), catalogPage.getOldPricesCount(), "Not all items have old prices.");
    }
    @Test(description = "Test #2: filter by availability")
    public void givenCatalogOpened_whenOnlyInStockClicked_thenFilterCatalogByAvailability() {
        var catalogPage = new KniganoshaCatalogPage(driver)
                .openPage()
                .filterByAvailability();
        Assert.assertEquals(catalogPage.getNotInStockCount(), 0, "Not all items are available.");
    }
    @Test(description = "Test #3: filter by genre")
    public void givenCatalogOpened_whenGenreIsSelected_thenFilterCatalogByGenre() {
        final String genre = TestDataReader.getTestDataLocal("t3_genre");
        var catalogPage = new KniganoshaCatalogPage(driver)
                .openPage()
                .filterByGenre(genre);
        Assert.assertEquals(catalogPage.getItemsCount(), catalogPage.getItemsByGenreCount(genre), "Not all items are of genre \""+genre+"\".");
    }
}