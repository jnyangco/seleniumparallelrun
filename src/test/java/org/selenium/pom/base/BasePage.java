package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
//    protected WebDriverWait waitLong;
//    protected WebDriverWait waitShort;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //we can have different wait variables to be used on other pages
        //waitLong = new WebDriverWait(driver, Duration.ofSeconds(30));
        //waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void load(String endPoint) {
        System.out.println("Start >> Browser");
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    public void waitForOverlaysToDisapper(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE : " +overlays.size());
        if(overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS ARE INVISIBLE");
        } else {
            System.out.println("OVERLAY NOT FOUND");
        }
    }

//    public WebElement waitForElementToBeVisible(By element) {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//    }


}
