package org.selenium.pom.tests;

import org.selenium.pom.api.actions.CartApi;
import org.selenium.pom.api.actions.SignUpApi;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.CheckoutPage;
import org.selenium.pom.utils.FakerUtils;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class APITest2_CheckoutTest extends BaseTest {

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {

        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.load();

        CartApi cartApi = new CartApi();
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        Thread.sleep(5000);

        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();

        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.selectDirectBankTransfer();
        checkoutPage.placeOrder();
        Assert.assertEquals(checkoutPage.getSuccessNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);

        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User();
        user.setUsername(username);
        user.setPassword("Password@1234");
        user.setEmail(username + "@yopmail.com");

        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        Thread.sleep(3000);

        CartApi cartApi = new CartApi(signUpApi.getCookies()); //pass signUpApi (user is logged in before adding a product to cart)
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);
        Thread.sleep(3000);

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.load();

        injectCookiesToBrowser(signUpApi.getCookies());//use signUpApi cookies instead of cartApi cookies
                                                        //since when we load the Checkout page, we need the user to be logged in


        checkoutPage.load(); //link <click here to login> should not displayed
        Thread.sleep(3000);
        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.selectDirectBankTransfer();
        checkoutPage.placeOrder();
        Assert.assertEquals(checkoutPage.getSuccessNotice(), "Thank you. Your order has been received.");
    }
}
