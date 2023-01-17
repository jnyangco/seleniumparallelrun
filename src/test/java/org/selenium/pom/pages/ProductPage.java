package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class ProductPage extends BasePage {

    private final By title = By.xpath("//h1[@class='product_title entry-title']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/product/blue-shoes/");

    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public void waitProductPageLoaded() {
        wait.until(ExpectedConditions.urlContains("/product"));
    }
}
