package org.selenium.pom.utils;

import org.selenium.pom.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    //Singleton Design Pattern

    //private constructor
    //we don't want to any other class to create instance of this class
    //only this class should be able to create its own instance
    private ConfigLoader() {
        String env = System.getProperty("env", String.valueOf(EnvType.STAGING));
        switch (EnvType.valueOf(env)) {
            case STAGING:
                properties = PropertyUtils.propertyLoader("src/test/resources/config_stg.properties");
                break;
            case PRODUCTION:
                properties = PropertyUtils.propertyLoader("src/test/resources/config_prod.properties");
                break;
            default:
                throw new IllegalStateException("Invalid env type: " +env);
        }
    }

    //configLoader next call will not be null (static - can change value)
    //configLoader will only be 1 instance of this class throughout the program
    public static ConfigLoader getInstance() {
        if(configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    //Note: Why we are creating separate methods for each property
    //Many times we face issues fetching the properties due to spelling mistakes
    //we get null pointer exception and try to figure out why we are getting the error
    //also these are global config -> do not proceed if not loaded
    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("Property baseUrl is not specified in the config_stg.properties file ");
    }

    public String getUsername() {
        String prop = properties.getProperty("username");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("Property username is not specified in the config_stg.properties file ");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if(prop != null)
            return prop;
        else
            throw new RuntimeException("Property property is not specified in the config_stg.properties file ");
    }

}
