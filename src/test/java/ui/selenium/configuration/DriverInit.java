package ui.selenium.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import mobile.exceptions.DriverNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static ui.selenium.utils.Utils.getProperty;

public class DriverInit {

    protected static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver== null) {
            if (getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
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
