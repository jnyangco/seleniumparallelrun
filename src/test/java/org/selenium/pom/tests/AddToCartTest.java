package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataproviders.MyDataProvider;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() throws IOException {
        Product product = new Product(1215);

        StorePage storePage = new StorePage(getDriver()).load();
        storePage.clickAddToCartBtn(product.getName());
        storePage.clickViewCart();

        CartPage cartPage = new CartPage(getDriver());
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }

    @Test(dataProvider = "getFeaturedProducts", dataProviderClass = MyDataProvider.class)
    public void addToCartFeaturedProducts(Product product) {
        HomePage homePage = new HomePage(getDriver());
        homePage.load();
        homePage.clickAddToCartBtn(product.getName());
        homePage.clickViewCart();

        CartPage cartPage = new CartPage(getDriver());
        Assert.assertEquals(cartPage.getProductName(), product.getName());
    }
}
