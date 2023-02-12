package mobile.config;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static mobile.config.ConfDriver.quit;
import static mobile.config.ConfDriver.getDriver;

public class Base {

    protected static AppiumDriver<WebElement> driver;

    @BeforeMethod
    public void setUp() {
       driver = getDriver();
    }

    @AfterMethod
    public void tearDown() {
        quit();
    }
}
