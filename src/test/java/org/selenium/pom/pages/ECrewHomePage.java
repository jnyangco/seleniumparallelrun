package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.testng.Assert;

public class ECrewHomePage extends BasePage {

    private final By loadingIcon = By.xpath("//div[@id='eCrewSpinner']");
    private final By crewAvatar = By.xpath("//div[@id='crewAvatar']");
    private final By eCrewLogo = By.xpath("//img[@id='eCrewlogo']");
    private final By crewName = By.xpath("//div[@view_id='crewname']/div");

    private final By crewScheduleButton = By.xpath("//span[text()='Crew Schedule']");
    private final By myScheduleButton = By.xpath("//span[text()='My Schedule']");
    private final By dutyDetailsButton = By.xpath("//button[text()='Duty details']");



    public ECrewHomePage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/");
    }

    //note: when navigating to other page -> use Fluent Interface -> return object of the Page
    public void waitForLoadingToDisappear() {
        System.out.println(">> verifyUserIsLoggedIn");

        waitForLoadingToDisappear(loadingIcon);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(crewAvatar));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(eCrewLogo));
//        String name = getCrewName();
//        System.out.println("Crew Name -> " +name);


        //wait.until(ExpectedConditions.visibilityOfElementLocated(dutyDetailsButton)).click();
        //wait.until(ExpectedConditions.elementToBeClickable(dutyDetailsButton)).click();
        //driver.findElement(dutyDetailsButton).click();


    }

//    public String getCrewName() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(crewName)).getText();
//    }

    public void clickCrewSchedule() {
        System.out.println(">> clickCrewSchedule");
        driver.findElement(crewScheduleButton).click();
        //wait.until(ExpectedConditions.elementToBeClickable(dutyDetailsButton)).click();
    }

    public void clickMySchedule() {
        System.out.println(">> clickMySchedule");
        driver.findElement(myScheduleButton).click();
        //wait.until(ExpectedConditions.elementToBeClickable(dutyDetailsButton)).click();
    }

    public void clickDutyDetails() {
        System.out.println(">> clickDutyDetails");
        //driver.findElement(dutyDetailsButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(dutyDetailsButton)).click();
    }
}
