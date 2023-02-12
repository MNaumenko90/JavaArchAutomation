package ui.selenium.configuration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static ui.selenium.configuration.DriverInit.getDriver;
import static ui.selenium.configuration.DriverInit.quit;
import static ui.selenium.utils.Utils.getProperty;

public class Base {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        driver.get((String) getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void quitDriver() {
        quit();
    }
}
