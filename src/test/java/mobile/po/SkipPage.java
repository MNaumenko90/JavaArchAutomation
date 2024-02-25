package mobile.po;

import mobile.config.base.impl.WebElementControl;
import org.openqa.selenium.By;

import static mobile.config.base.impl.Condition.clickable;
import static mobile.config.base.impl.Condition.visible;

public class SkipPage extends WebElementControl {

    private final By skip = By.id("org.wikipedia:id/fragment_onboarding_skip_button");


    public void clickSkip() {
        element(skip).shouldBe(visible, clickable).click();
    }
}
