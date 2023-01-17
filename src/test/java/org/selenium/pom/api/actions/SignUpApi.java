package org.selenium.pom.api.actions;

import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.selenium.pom.objects.User;
import org.selenium.pom.utils.ConfigLoader;

import java.util.HashMap;

public class SignUpApi {

    //import from RestAssured (not Selenium/Apache)
    private Cookies cookies;


    //getter
    public Cookies getCookies() {
        return cookies;
    }

    //html to fetch
    //<input type="hidden" id="woocommerce-register-nonce" name="woocommerce-register-nonce" value="6945dc48c9"/>
    private String fetchRegisterNonceValueUsingGroovy() {
        Response response = getAccount();
        return response.htmlPath().getString("**.findAll { it.@name == 'woocommerce-register-nonce' }.@value");
    }

    private String fetchRegisterNonceValueUsingJsoup() {
        Response response = getAccount();
        Document doc = Jsoup.parse(response.body().prettyPrint());//converted html to text
        Element element = doc.selectFirst("#woocommerce-register-nonce");
        return element.attr("value");
    }

    //GET CALL
    private Response getAccount() {
        Cookies cookies = new Cookies();
        Response response = RestAssured.
        given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                cookies(cookies).
                log().all().
        when().
                get("/account").
        then().
                log().all().
                extract().
                response();
        if(response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to fetch the account, HTTP Status Code : " +response.getStatusCode());
        }
        return response;
    }

    //POST CALL
    //postAccount
    public Response register(User user) {
        Cookies cookies = new Cookies();
        Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("username", user.getUsername());
        formParams.put("email", user.getEmail());
        formParams.put("password", user.getPassword());
        formParams.put("woocommerce-register-nonce", fetchRegisterNonceValueUsingJsoup());
        formParams.put("register", "Register");

        Response response = RestAssured.
            given().
                baseUri(ConfigLoader.getInstance().getBaseUrl()).
                headers(headers).
                formParams(formParams).
                cookies(cookies).
                log().all().
            when().
                post("/account").
            then().
                log().all().
                extract().
                response();
        if(response.getStatusCode() != 302) {
            throw new RuntimeException("Failed to register the account, HTTP Status Code : " +response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
