package mobile.config.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import mobile.config.props.BaseConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.System.getProperties;
import static org.aeonbits.owner.ConfigFactory.create;

import java.net.URL;

public class DriverInit {

    private static volatile AppiumDriver driver;
    private static final Logger LOGGER = LogManager.getLogger();
    private static final BaseConfig config = create(BaseConfig.class, getProperties());

    private DriverInit() {
    }

    @SneakyThrows
    public static AppiumDriver getDriver() {
        if (driver == null) {
            synchronized (DriverInit.class) {
                LOGGER.info("Init driver");
                if (driver == null) {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("platformName", config.platformName());
                    capabilities.setCapability("deviceName", config.deviceName());
                    capabilities.setCapability("platformVersion", config.platformVersion());
                    capabilities.setCapability("automationName", config.automationName());
                    capabilities.setCapability("appPackage", config.appPackage());
                    capabilities.setCapability("appActivity", config.appActivity());
                    capabilities.setCapability("app", config.app());

                    driver = new AndroidDriver(new URL(config.url()), capabilities);
                }
            }
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
