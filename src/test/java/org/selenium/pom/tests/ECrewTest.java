package org.selenium.pom.tests;

import io.qameta.allure.Description;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataproviders.MyDataProvider;
import org.selenium.pom.objects.UserLogin;
import org.selenium.pom.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ECrewTest extends BaseTest {

    @Test(invocationCount=30, threadPoolSize=30)
    public void eCrewLoginTest() throws InterruptedException {

        System.out.println(">> Start Execution");
        ECrewLoginPage eCrewLoginPage = new ECrewLoginPage(getDriver());
        eCrewLoginPage.load();

        System.out.println(">> Enter Crew ID and Password");
        eCrewLoginPage.login("254830", "67025116");

        ECrewHomePage eCrewHomePage = new ECrewHomePage(getDriver());
        eCrewHomePage.waitForLoadingToDisappear();
        System.out.println(">> User is Logged In");

        Thread.sleep(50000);
        switchFrame(0);
        eCrewHomePage.clickFitUnfit();
        eCrewHomePage.waitForLoadingToDisappear();
        System.out.println(">> Execution Completed");

    }
}
