package org.selenium.pom.dataproviders;

import org.selenium.pom.objects.UserLogin;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {

    //DATA PROVIDER
    @DataProvider(name="userLogins", parallel = true)
    public Object[] getUserLogins() throws IOException {
        return JacksonUtils.deserializeJson("userlogins.json", UserLogin[].class);
    }
}
