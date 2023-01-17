package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {

    private final By productName = By.xpath("//td[@class='product-name']/a");
    private final By checkoutBtn = By.xpath("//a[contains(@class,'checkout-button')]");
    private final By cartHeading = By.cssSelector(".has-text-align-center");

    //NOTE: We cannot use PageFactory when using custom locator during runtime
    //PageFactory only accepts constants, once it is defined we cannot change the locator
    @FindBy(xpath = "//td[@class='product-name']/a") private WebElement productName1;
    @FindBy(xpath = "//a[contains(@class,'checkout-button')]") @CacheLookup private WebElement checkoutBtn1;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
        //return driver.findElement(productName).getText();
    }

    public void clickCheckoutBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        //driver.findElement(checkoutBtn).click();
    }
}
