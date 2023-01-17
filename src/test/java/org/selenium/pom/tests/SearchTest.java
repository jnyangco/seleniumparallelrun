package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.ProductPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch() {
        String searchFor = "Blue";

        StorePage storePage = new StorePage(getDriver()).load();
        storePage.search(searchFor);
        storePage.waitSearchPageLoaded();
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
    }

    /*
    @Test
    public void searchWithExactMatch() {
        String searchFor = "Blue Shoes";

        StorePage storePage = new StorePage(getDriver()).load();
        storePage.search(searchFor);

        ProductPage productPage = new ProductPage(getDriver());
        productPage.waitProductPageLoaded();
        Assert.assertEquals(productPage.getTitle(), searchFor);
    }

    @Test
    public void searchNonExistingProduct() {
        String searchFor = "Test Product";

        StorePage storePage = new StorePage(getDriver()).load();
        storePage.search(searchFor);
        storePage.waitSearchPageLoaded();
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
        Assert.assertEquals(storePage.getNoProductsMessage(), "No products were found matching your selection.");
    }

     */
}
