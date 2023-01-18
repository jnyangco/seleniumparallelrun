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

//    @Test(dataProvider = "userLogins", dataProviderClass = MyDataProvider.class)
//    public void eCrewLoginTest(UserLogin userLogin) {
//
//        ECrewLoginPage eCrewLoginPage = new ECrewLoginPage(getDriver());
//        eCrewLoginPage.load();
//        eCrewLoginPage.login(userLogin.getCrewID(), userLogin.getPassword());
//
//        ECrewHomePage eCrewHomePage = new ECrewHomePage(getDriver());
//        eCrewHomePage.verifyUserIsLoggedIn();
//    }

    @Test(invocationCount=2, threadPoolSize=2)
    public void eCrewLoginTest() throws InterruptedException {

        System.out.println(">> Start Execution");
        ECrewLoginPage eCrewLoginPage = new ECrewLoginPage(getDriver());
        eCrewLoginPage.load();
        eCrewLoginPage.login("254830", "67025116");

        System.out.println(">> Verify User is Logged In");
        ECrewHomePage eCrewHomePage = new ECrewHomePage(getDriver());
        eCrewHomePage.waitForLoadingToDisappear();
        Thread.sleep(5000);
        //switchFrame(0);
        //eCrewHomePage.clickDutyDetails();
        eCrewHomePage.clickCrewSchedule();
        eCrewHomePage.clickMySchedule();
        eCrewHomePage.waitForLoadingToDisappear();

        eCrewHomePage.clickNextPeriod();
        eCrewHomePage.waitForLoadingToDisappear();
    }
}
