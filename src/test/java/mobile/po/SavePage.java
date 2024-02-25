package mobile.po;

import mobile.config.base.impl.BaseMethods;
import org.openqa.selenium.By;

import static mobile.config.base.impl.Condition.visible;

public class SavePage extends BaseMethods {

    private final By save = By.xpath("//android.widget.TextView[@content-desc='Save']");

    public void clickSaveButton() {
        element(save).shouldBe(visible).click();
    }
}
