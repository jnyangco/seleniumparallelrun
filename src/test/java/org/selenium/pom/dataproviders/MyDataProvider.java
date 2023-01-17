package org.selenium.pom.dataproviders;

import org.selenium.pom.objects.Product;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {

    private int id;
    private String name;

    //DATA PROVIDER
    @DataProvider(name="getFeaturedProducts", parallel = false)
    public Object[] getFeaturedProducts() throws IOException {

        return JacksonUtils.deserializeJson("products.json", Product[].class);

        //try to add another parameter in products.json (featured: true/false)
        //then filter here before returning the object


    }
}
