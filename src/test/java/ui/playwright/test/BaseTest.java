package ui.playwright.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static ui.playwright.config.page.PageInit.getPage;
import static ui.playwright.config.page.PageInit.quit;

public class BaseTest {

    @BeforeMethod
    void setUp() {
        getPage().navigate("https://playwright.dev/");
    }

    @AfterMethod
    void close() {
        quit();
    }
}
