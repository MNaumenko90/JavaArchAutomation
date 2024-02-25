package mobile.config.base.impl;

import io.appium.java_client.AppiumDriver;
import mobile.config.base.methods.Waiter;
import mobile.config.base.methods.WebElementControlMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static mobile.config.driver.DriverInit.getDriver;

public class WebElementControl implements WebElementControlMethods, Waiter {

    protected AppiumDriver driver = getDriver();

    private By element = null;

    public WebElementControl element(By by) {
        setElement(by);
        return this;
    }

    public WebElement shouldBe(Condition condition) {
        return condition.waitElement(element, waiter(15));
    }

    public WebElement shouldBe(Condition condition, int time) {
        return condition.waitElement(element, waiter(time));
    }

    public WebElement shouldBe(Condition ...conditions) {
        for (Condition condition: conditions) {
            condition.waitElement(element, waiter(15));
        }
        return conditions[0].waitElement(element, waiter(15));
    }

    public WebDriverWait waiter(long timeOutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds));
    }

    private void setElement(By element) {
        this.element = element;
    }
}
