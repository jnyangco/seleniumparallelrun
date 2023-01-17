package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.ProductPage;
import org.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigateFromHomeToStoreUsingMainMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.load();
        homePage.navigateToStoreUsingMenu();

        StorePage storePage = new StorePage(getDriver());
        Assert.assertEquals(storePage.getTitle(), "Store");
    }

    /*
    @Test
    public void NavigateFromStoreToProductPage() {
        StorePage storePage = new StorePage(getDriver());
        storePage.load();
        storePage.navigateToProductPageBlueShoes();

        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertEquals(productPage.getTitle(), "Blue Shoes");
    }

    @Test
    public void NavigateFromHomeToFeaturedProductPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.load();
        homePage.navigateToProductPageBlueShoes();

        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertEquals(productPage.getTitle(), "Blue Shoes");
    }

     */
}
