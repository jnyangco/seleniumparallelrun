package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class ECrewLoginPage extends BasePage {

    private final By crewID = By.xpath("//input[@placeholder='Crew ID']");
    private final By password = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[text()='Log in']");
    private final By loadingIcon = By.xpath("//div[@id='eCrewSpinner']");

    public ECrewLoginPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/");
    }

    //note: when navigating to other page -> use Fluent Interface -> return object of the Page
    public void login(String strCrewID, String strPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(crewID)).sendKeys(strCrewID);
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(strPassword);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon)).equals(true);
    }

//    public void clickLoginButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
//    }
}
