package mobile.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import mobile.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import static mobile.utils.Util.getProperty;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfDriver {

    protected static AppiumDriver<WebElement> driver;

    @Step("Get driver")
    public static AppiumDriver<WebElement> getDriver() {
        if (getProperty("start").equals("android")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", getProperty("platformName.android"));
            capabilities.setCapability("deviceName",getProperty("deviceName.android"));
            capabilities.setCapability("platformVersion",getProperty("platformVersion.android"));
            capabilities.setCapability("automationName",getProperty("automationName.android"));
            capabilities.setCapability("appPackage",getProperty("appPackage.android"));
            capabilities.setCapability("appActivity",getProperty("appActivity.android"));
            capabilities.setCapability("app",getProperty("app.android"));

            try {
                return driver = new AndroidDriver<>(new URL(getProperty("url.driver").toString()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (getProperty("driver.run").equals("ios")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", getProperty("platformName.ios"));
            capabilities.setCapability("deviceName",getProperty("deviceName.ios"));
            capabilities.setCapability("platformVersion",getProperty("platformVersion.ios"));
            capabilities.setCapability("automationName",getProperty("automationName.ios"));
            capabilities.setCapability("appPackage",getProperty("appPackage.ios"));
            capabilities.setCapability("appActivity",getProperty("appActivity.ios"));
            capabilities.setCapability("app",getProperty("app.ios"));
            try {
                return driver = new IOSDriver<>(new URL(getProperty("url.driver").toString()), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new DriverNotFoundException("You select incorrect driver, please select android or ios");
            } catch (DriverNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
