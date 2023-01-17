package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.User;

public class CheckoutPage extends BasePage {
    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.cssSelector("#billing_email");

    private final By placeOrderBtn = By.xpath("//button[@id='place_order']");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By clickHereToLoginLink = By.cssSelector(".showlogin");
    private final By usernameFld = By.cssSelector("#username");
    private final By passwordFld = By.cssSelector("#password");
    private final By loginBtn = By.xpath("//button[@name='login']");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    private final By countryDropdown = By.id("billing_country");
    private final By stateDropdown = By.id("billing_state");

    By alternateCountryDropdown = By.id("select2-billing_country-container");
    By alternateStateDropdown = By.id("select2-billing_state-container");

    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");
    private final By productName = By.cssSelector("td.product-name");




    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/checkout/");
        //return this;
    }

    public void enterFirstName(String text) {
        //WebElement element = waitForElementToBeVisible(firstNameFld);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameFld));
        element.clear();
        element.sendKeys(text);
        //driver.findElement(firstNameFld).clear();
        //driver.findElement(firstNameFld).sendKeys(text);
    }

    public void enterLastName(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameFld));
        element.clear();
        element.sendKeys(text);
    }

    public void selectCountry(String countryName) {
        //Select is not working on firefox
        //Select select = new Select(driver.findElement(countryDropdown));
        //select.selectByVisibleText(countryName);

        wait.until(ExpectedConditions.elementToBeClickable(alternateCountryDropdown)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+countryName+"']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void selectState(String stateName) {
        //Select select = new Select(driver.findElement(stateDropdown));
        //select.selectByVisibleText(stateName);

        wait.until(ExpectedConditions.elementToBeClickable(alternateStateDropdown)).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+stateName+"']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void enterAddressLineOne(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addressLineOneFld));
        element.clear();
        element.sendKeys(text);
    }

    public void enterCity(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));
        element.clear();
        element.sendKeys(text);
    }

    public void enterPostCode(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingPostCodeFld));
        element.clear();
        element.sendKeys(text);
    }

    public void enterEmail(String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
        element.clear();
        element.sendKeys(text);
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        enterFirstName(billingAddress.getFirstName());
        enterLastName(billingAddress.getLastName());
        selectCountry(billingAddress.getCountry());
        enterAddressLineOne(billingAddress.getAddressLineOne());
        enterCity(billingAddress.getCity());
        selectState(billingAddress.getState());
        enterPostCode(billingAddress.getPostalCode());
        enterEmail(billingAddress.getEmail());
        return this;
    }

    public void placeOrder() {
        waitForOverlaysToDisapper(overlay);
        driver.findElement(placeOrderBtn).click(); //note: you can just use findElement directly if you think it is not needed
    }

    public String getSuccessNotice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }

    public void clickHereToLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(clickHereToLoginLink)).click();
    }

    public void enterUsername(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFld)).sendKeys(text);
    }

    public void enterPassword(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).sendKeys(text);
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void login(User user) {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        clickLoginBtn();
    }

    public void selectDirectBankTransfer() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if(!element.isSelected()) {
            element.click();
        }
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

}
