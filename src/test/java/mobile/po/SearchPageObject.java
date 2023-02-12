package mobile.po;

import io.appium.java_client.AppiumDriver;
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


    public SearchPageObject clickSkipButton() {
        click(SkipButton, f("Cannot find element: %s", SkipButton));
        return this;
    }

    public SearchPageObject searchAppiumText() {
        click(SearchField, f("Cannot find element: %s", SearchField));
        sendKeys(SearchField, f("Cannot find element: %s", SearchField), "Appium");
        return this;
    }

    public String getSearchedArticle() {
        return getText(SearchedText, f("Cannot find element: %s", SearchedText));
    }

    public SearchPageObject clickSearchedText() {
        click(SearchedText, f("Cannot find element: %s", SearchedText));
        return this;
    }

    public SearchPageObject swipeToUp() {
        swipeUp(4);
        return this;
    }
}
