package mobile.po;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static mobile.utils.Util.f;

public class SafeListPageObject extends MainPageObject{

    public SafeListPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private final By SaveButton = By.xpath("//*[@text='Save']");
    private final By AddToList = By.xpath("//*[@text='ADD TO LIST']");
    private final By NameList = By.xpath("//*[@text='Name of this list']");
    private final By ConfirmCreateNameToList = By.xpath("//*[@text='OK']");
    private final By ViewList = By.xpath("//*[@text='VIEW LIST']");
    private final By TitleSavedArticle = By.xpath("//*[@text='Automation for Apps']");
    private final By MoreOptions = By.xpath("//*[@content-desc='More options']");
    private final By DeleteList = By.xpath("//*[@text='Delete list']");
    private final By ConfirmDelete = By.xpath("//*[@text='OK']");

    @Step("Click save button")
    public SafeListPageObject clickSaveButton() {
        click(SaveButton, f("Cannot click the save button: %s", SaveButton));
        return this;
    }

    @Step("Click button add to list")
    public SafeListPageObject clickAddToList() {
        click(AddToList, f("Cannot click the add to list button: %s", AddToList));
        return this;
    }

    @Step("Fill name list {text}")
    public SafeListPageObject fillNameList(String text) {
        sendKeys(NameList, f("Cannot fill to %s to input: %s", text, NameList), text);
        return this;
    }

    @Step("Click confirm create name to list created before")
    public SafeListPageObject clickConfirmCreateNameToList() {
        click(ConfirmCreateNameToList, f("Cannot click the OK button: %s", ConfirmCreateNameToList));
        return this;
    }

    @Step("Click view list")
    public SafeListPageObject clickViewList() {
        click(ViewList, f("Cannot click the view list button: %s", ViewList));
        return this;
    }

    @Step("Swipe article left that delete article")
    public SafeListPageObject swipeArticleLeft() {
        swipeToElementLeft(TitleSavedArticle, f("Cannot swipe the element: %s", TitleSavedArticle));
        return this;
    }

    @Step("Click on button more option")
    public SafeListPageObject clickMoreOptions() {
        click(MoreOptions, f("Cannot click the more options button: %s", MoreOptions));
        return this;
    }

    @Step("Click delete button")
    public SafeListPageObject clickDeleteButton() {
        click(DeleteList, f("Cannot click the delete list button: %s", DeleteList));
        return this;
    }

    @Step("Click confirm delete button")
    public SafeListPageObject clickConfirmDelete() {
        click(ConfirmDelete, f("Cannot click the confirm delete button: %s", ConfirmDelete));
        return this;
    }
}
