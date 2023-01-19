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
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        //we can have different wait variables to be used on other pages
        //waitLong = new WebDriverWait(driver, Duration.ofSeconds(30));
        //waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void load(String endPoint) {
        System.out.println("Start >> Browser");
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

    public void waitForLoadingToDisappear(By loading) {
        List<WebElement> overlays = driver.findElements(loading);
        //System.out.println("LOADING SIZE : " +overlays.size());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loading));
        System.out.println(">> Loading Completed");
    }

}
