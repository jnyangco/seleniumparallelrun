package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class ECrewHomePage extends BasePage {

    private final By crewAvatar = By.xpath("//div[@id='crewAvatar']");

    public ECrewHomePage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/");
    }

    //note: when navigating to other page -> use Fluent Interface -> return object of the Page
    public void verifyUserIsLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(crewAvatar)).isDisplayed();
    }
}
