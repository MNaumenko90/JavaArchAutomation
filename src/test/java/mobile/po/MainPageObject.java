package mobile.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public class MainPageObject {

    protected AppiumDriver<WebElement> driver;
    private final int TIME = 10;

    public MainPageObject(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

    private WebElement waitForElementPresent(By by, String errorMessage, long timeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void click(By by, String errorMessage) {
        waitForElementPresent(by, errorMessage, TIME).click();
    }

    protected void sendKeys(By by, String errorMessage, String text) {
         waitForElementPresent(by, errorMessage, TIME).sendKeys(text);
    }

    protected void clear(By by, String errorMessage) {
        waitForElementPresent(by, errorMessage, TIME).clear();
    }

    protected String getText(By by, String errorMessage) {
        return waitForElementPresent(by, errorMessage, TIME).getText();
    }

    void swipeUp(int timeOut) {
        Dimension dimension = driver.manage().window().getSize();
        int x = dimension.width / 2;
        int start_y = (int) (dimension.height * 0.8);
        int end_y = (int) (dimension.height * 0.2);

        new TouchAction<>(driver)
                .press(point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(timeOut)))
                .moveTo(point(x, end_y))
                .release().perform();

    }

    protected void swipeToElement(By by, String error, int max_swipes) {

        int swipes = 0;

        while (driver.findElements(by).size() == 0) {
            if (swipes == max_swipes) {
                waitForElementPresent(by, error, 3);
                break;
            }
            swipeUp(1);
            ++swipes;
        }
    }

    protected void swipeToElementLeft(By by, String error) {
        WebElement ele = waitForElementPresent(by, error, TIME);

        int left_x = ele.getLocation().getX();
        int right_x = left_x + ele.getSize().getWidth();

        int upper_y = ele.getLocation().getY();
        int lower_y = upper_y + ele.getSize().getHeight();

        int middle_y = (upper_y + lower_y) /2;

        new TouchAction<>(driver)
                .press(point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(150)))
                .moveTo(point(left_x, middle_y))
                .release().perform();
    }
}
