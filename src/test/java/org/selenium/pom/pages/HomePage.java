package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");
    private final By productBlueShoes = By.xpath("//h2[text()='Blue Shoes']");
    private final By viewCartLink = By.xpath("//a[@title='View cart']");

    public HomePage(WebDriver driver) {
        super(driver); //passing this driver to the constructor of BasePage class
    }

    public void load() {
        load("/"); //this is just a basepage
    }

    //note: when navigating to other page -> use Fluent Interface -> return object of the Page
    public StorePage navigateToStoreUsingMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
        return new StorePage(driver);

    }

    public void navigateToProductPageBlueShoes() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productBlueShoes)).click();
    }

    private By getAddToCartBtnElement(String productName) {
        return By.xpath("//a[@aria-label='Add “" +productName+ "” to your cart']");
    }

    public void clickAddToCartBtn(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
