package mobile.po;

import mobile.config.base.impl.BaseMethods;
import org.openqa.selenium.By;

import static mobile.config.base.impl.Condition.clickable;
import static mobile.config.base.impl.Condition.visible;

public class ListSavedArticlePage extends BaseMethods {

    private final By addToListButton = By.xpath("//android.widget.Button[@resource-id='org.wikipedia:id/snackbar_action']");

    private final By nameList = By.xpath("//android.widget.EditText[@resource-id=\"org.wikipedia:id/text_input\"]");

    private final By okButton = By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]");

    private final By viewList = By.xpath("//android.widget.Button[@resource-id=\"org.wikipedia:id/snackbar_action\"]");

    private final By appiumArticle = By.xpath("//android.view.ViewGroup[@resource-id=\"org.wikipedia:id/page_list_item_container\"]");

    public ListSavedArticlePage clickAddToListButton() {
        element(addToListButton).shouldBe(visible, clickable).click();
        return this;
    }

    public ListSavedArticlePage fillNameList(String text) {
        element(nameList).shouldBe(visible).sendKeys(text);
        return this;
    }

    public ListSavedArticlePage clickOkButton() {
        element(okButton).shouldBe(visible).click();
        return this;
    }

    public ListSavedArticlePage viewList() {
        element(viewList).shouldBe(visible).click();
        return this;
    }

    public void swipeElementRight(int time) {
        swipeElementRight(appiumArticle, time);
    }

}
