package mobile.po;

import mobile.config.base.impl.BaseMethods;
import mobile.config.base.impl.Condition;
import org.openqa.selenium.By;

import static mobile.config.base.impl.Condition.clickable;
import static mobile.config.base.impl.Condition.visible;

public class SearchPage extends BaseMethods {

    private final By search = By.xpath("//*[@text='Search Wikipedia']");
    private final By input = By.id("org.wikipedia:id/search_src_text");

    public SearchPage clickOnSearchField() {
        element(search).shouldBe(visible, clickable).click();
        return new SearchPage();
    }

    public SearchPage fillInput(String text) {
        element(input).shouldBe(visible).sendKeys(text);
        return new SearchPage();
    }
}
