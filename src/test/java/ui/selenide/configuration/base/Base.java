package ui.selenide.configuration.base;

import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ui.selenide.utils.Utils.getProperty;


public class Base {

    @BeforeMethod
    public void setUp() {
        open((String) getProperty("url"));
        getWebDriver().manage().window().maximize();
    }
}
