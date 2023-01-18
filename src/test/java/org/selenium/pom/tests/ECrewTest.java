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

    @Test(invocationCount=40, threadPoolSize=40)
    public void eCrewLoginTest() {

        ECrewLoginPage eCrewLoginPage = new ECrewLoginPage(getDriver());
        eCrewLoginPage.load();
        eCrewLoginPage.login("254830", "67025116");

        ECrewHomePage eCrewHomePage = new ECrewHomePage(getDriver());
        eCrewHomePage.verifyUserIsLoggedIn();
    }
}
