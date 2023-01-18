package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.selenium.pom.constants.BrowserType;

import java.time.Duration;

public class DriverManager {

    public WebDriver initializeDriver(String browser) {
        //System.setProperty("webdriver.chrome.driver", "C:\\Selenium Configuration\\browser_jars\\chromedriver.exe");
        //This line of code will set up the chromedriver automatically
//        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        //String browser = System.getProperty("browser", "CHROME");//if null - set default to CHROME

        //switch (browser.toLowerCase()) { }
        switch (BrowserType.valueOf(browser)) { //converting browser string to enum constants
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("headless");
                WebDriverManager.chromedriver().cachePath(System.getProperty("user.dir")+"\\src\\test\\java\\org\\selenium\\pom\\drivers").setup();
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath(System.getProperty("user.dir")+"\\src\\test\\java\\org\\selenium\\pom\\drivers").setup();
                driver = new FirefoxDriver();
                break;
            case UNIT:
                //WebDriverManager.firefoxdriver().cachePath(System.getProperty("user.dir")+"\\src\\test\\java\\org\\selenium\\pom\\drivers").setup();
                driver = new HtmlUnitDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name: " +browser);
        }

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
