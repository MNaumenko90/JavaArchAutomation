package ui.selenium.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import mobile.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static ui.selenium.utils.Utils.getProperty;

public class DriverInit {

    protected static WebDriver driver;


    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("114.0"); // Задайте нужную версию браузера
        capabilities.setCapability("timeZone", "Europe/Berlin");
        capabilities.setCapability("enableLog", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableVNC", true);


        URL selenoidURL = null;
        try {
            selenoidURL = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        if (driver== null) {
            if (getProperty("browser").equals("chrome")) {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
                driver = new RemoteWebDriver(selenoidURL, capabilities);
            } else if (getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                try {
                    throw new DriverNotFoundException("Cannot start driver, select chrome or firefox");
                } catch (DriverNotFoundException e) {
                    throw new RuntimeException(e);
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
