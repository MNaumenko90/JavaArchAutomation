package mobile.po;

import io.appium.java_client.AppiumDriver;
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

    public SafeListPageObject clickSaveButton() {
        click(SaveButton, f("Cannot click the save button: %s", SaveButton));
        return this;
    }

    public SafeListPageObject clickAddToList() {
        click(AddToList, f("Cannot click the add to list button: %s", AddToList));
        return this;
    }

    public SafeListPageObject fillNameList(String text) {
        sendKeys(NameList, f("Cannot fill to %s to input: %s", text, NameList), text);
        return this;
    }

    public SafeListPageObject clickConfirmCreateNameToList() {
        click(ConfirmCreateNameToList, f("Cannot click the OK button: %s", ConfirmCreateNameToList));
        return this;
    }

    public SafeListPageObject clickViewList() {
        click(ViewList, f("Cannot click the view list button: %s", ViewList));
        return this;
    }

    public SafeListPageObject swipeArticleLeft() {
        swipeToElementLeft(TitleSavedArticle, f("Cannot swipe the element: %s", TitleSavedArticle));
        return this;
    }

    public SafeListPageObject clickMoreOptions() {
        click(MoreOptions, f("Cannot click the more options button: %s", MoreOptions));
        return this;
    }

    public SafeListPageObject clickDeleteButton() {
        click(DeleteList, f("Cannot click the delete list button: %s", DeleteList));
        return this;
    }

    public SafeListPageObject clickConfirmDelete() {
        click(ConfirmDelete, f("Cannot click the confirm delete button: %s", ConfirmDelete));
        return this;
    }
}
