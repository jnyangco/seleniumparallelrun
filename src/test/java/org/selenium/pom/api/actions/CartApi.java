package org.selenium.pom.api.actions;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.pom.utils.ConfigLoader;

import java.util.HashMap;

public class CartApi {
    private Cookies cookies;

    //IF Customer is NOT logged in -> use this constructor to create object of this class
    //we will not take any cookies
    public CartApi() {

    }

    //IF Customer is logged in
    //we will get the cookies from login API -> set cookies (not null)
    public CartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }


    //this is Post Call
    public Response addToCart(int productId, int quantity) {
        //Cookies cookies = new Cookies();
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("product_sku", "");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);

        if(cookies == null) {
            cookies = new Cookies();
        }

        Response response = RestAssured.
            given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
            when().
                post("/?wc-ajax=add_to_cart").
            then().
                log().all().
                extract().
                response();
        if(response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to add product " +productId +"to the cart" +
                    ", HTTP Status Code: " +response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }

    /*
    public Response addToCartFromProductPage(int productId, int quantity) {
        //Cookies cookies = new Cookies();
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, Object> formParams = new HashMap<>();
        formParams.put("add-to-cart", productId);
        formParams.put("quantity", quantity);

        if(cookies == null) {
            cookies = new Cookies();
        }

        Response response = RestAssured.
                given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
                when().
                post("/?wc-ajax=add_to_cart").
                then().
                log().all().
                extract().
                response();
        if(response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to add product " +productId +"to the cart" +
                    ", HTTP Status Code: " +response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
     */
}
