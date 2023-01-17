package org.selenium.pom.api.actions;

import org.selenium.pom.objects.User;
import org.selenium.pom.utils.FakerUtils;

public class DummyClass {

    public static void main(String[] args) {

        //GET API - Nonce
//        new SignUpApi().getAccount();
//        System.out.println("Nonce Value = " +new SignUpApi().fetchRegisterNonceValueUsingGroovy());
//        System.out.println("Nonce Value = " +new SignUpApi().fetchRegisterNonceValueUsingJsoup());

        //REGISTER API
        System.err.println("===================================================================================================================");
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User();
        user.setUsername(username);
        user.setPassword("Password@1234");
        user.setEmail(username + "@yopmail.com");
        SignUpApi signUpApi = new SignUpApi();
        signUpApi.register(user);
        System.out.println("REGISTER COOKIES -> " +signUpApi.getCookies());


        //ADD TO CART API
        System.err.println("===================================================================================================================");
        //CartApi -> not logged in
//        CartApi cartApi = new CartApi();

        //CartApi -> is logged in
        CartApi cartApi = new CartApi(signUpApi.getCookies());
        cartApi.addToCart(1215, 1);
        System.out.println("CART COOKIES -> " +cartApi.getCookies());
    }
}
