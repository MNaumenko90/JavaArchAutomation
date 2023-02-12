package mobile.config;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static mobile.config.ConfDriver.quit;
import static mobile.config.ConfDriver.getDriver;

public class Base {

    protected static AppiumDriver<WebElement> driver;

    @BeforeMethod
    @Step("Init driver")
    public void setUp() {
       driver = getDriver();
    }

    @AfterMethod
    @Step("Close driver")
    public void tearDown() {
        quit();
    }
}
