package mobile.po;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static mobile.utils.Util.f;

public class SearchPageObject extends MainPageObject{

    public SearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private final By SkipButton = By.id("org.wikipedia:id/fragment_onboarding_skip_button");
    private final By SearchField = By.xpath("//*[contains(@text,'Search Wikipedia')]");
    private final By SearchedText = By.xpath("//*[@text='Automation for Apps']");


    @Step("Click skip button")
    public SearchPageObject clickSkipButton() {
        click(SkipButton, f("Cannot find element: %s", SkipButton));
        return this;
    }

    @Step("Click search appium text")
    public SearchPageObject searchAppiumText() {
        click(SearchField, f("Cannot find element: %s", SearchField));
        sendKeys(SearchField, f("Cannot find element: %s", SearchField), "Appium");
        return this;
    }

    @Step("Get searched text before")
    public String getSearchedArticle() {
        return getText(SearchedText, f("Cannot find element: %s", SearchedText));
    }

    @Step("Click on searched text")
    public SearchPageObject clickSearchedText() {
        click(SearchedText, f("Cannot find element: %s", SearchedText));
        return this;
    }

    @Step("Swipe app to up")
    public SearchPageObject swipeToUp() {
        swipeUp(4);
        return this;
    }
}
