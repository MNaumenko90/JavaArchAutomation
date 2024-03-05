package ui.selenium.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ui.selenium.utils.Utils.f;
import static ui.selenium.configuration.DriverInit.getDriver;

public class BaseMethods {

    private WebElement waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.withMessage(f("Cannot find element: %s", by));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void click(By by) {
        waitForElementPresent(by).click();
    }

    protected void sendKeys(By by, String text) {
        waitForElementPresent(by).sendKeys(text);
    }

    protected void clear(By by) {
        waitForElementPresent(by).clear();
    }

    protected String getText(By by) {
        return waitForElementPresent(by).getText();
    }
}

