package org.selenium.pom.base;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.selenium.pom.utils.CookieUtils;
import org.testng.annotations.*;

import java.util.List;

public class BaseTest {
    //protected WebDriver driver;
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    //Getter and Setter
    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(@Optional String browser) {
        //Use this line if running testng.xml with browser parameter
        browser = System.getProperty("browser", browser);

        //Use this line if running pom.xml, or direct testng run in class
        /*
        if(browser == null) {
            browser = "CHROME";
        }
        */

        //1-maven, 2-testng (if maven=null) then get from testng.xml, 3-from config file (so you can run by right-clicking on method name)
        //Usage: 1-maven only -> CICD, 2-testng.xml only, 3-maven with testng.xml

        //driver = new DriverManager().initializeDriver(browser);
        setDriver(new DriverManager().initializeDriver(browser));
        System.out.println("CURRENT THREAD: " +Thread.currentThread().getId() +", " +"DRIVER = " +getDriver());
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
        System.out.println("CURRENT THREAD: " +Thread.currentThread().getId() +", " +"DRIVER = " +getDriver());

        Thread.sleep(3000);
        getDriver().quit();
    }

    public void injectCookiesToBrowser(Cookies cookies) {
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie: seleniumCookies) {
            getDriver().manage().addCookie(cookie);
        }
    }


}
