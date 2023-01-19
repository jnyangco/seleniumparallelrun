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
    private final By dutyFitUnfitButton = By.xpath("//button[text()='Fit/Unfit']");

    private final By nextPeriodButton = By.xpath("//button[text()='Next Period']");


    public ECrewHomePage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/");
    }

    public void waitForLoadingToDisappear() {
        System.out.println(">> verifyUserIsLoggedIn");
        waitForLoadingToDisappear(loadingIcon);
    }

    public void clickCrewSchedule() {
        System.out.println(">> clickCrewSchedule");
        wait.until(ExpectedConditions.elementToBeClickable(crewScheduleButton)).click();
    }

    public void clickMySchedule() {
        System.out.println(">> clickMySchedule");
        wait.until(ExpectedConditions.elementToBeClickable(myScheduleButton)).click();
    }

    public void clickNextPeriod() {
        System.out.println(">> clickNextPeriod");
        wait.until(ExpectedConditions.elementToBeClickable(nextPeriodButton)).click();
    }

    public void clickDutyDetails() {
        System.out.println(">> clickDutyDetails");
        wait.until(ExpectedConditions.elementToBeClickable(dutyDetailsButton)).click();
    }

    public void clickFitUnfit() {
        System.out.println(">> clickFitUnfit");
        wait.until(ExpectedConditions.elementToBeClickable(dutyFitUnfitButton)).click();
    }


}
