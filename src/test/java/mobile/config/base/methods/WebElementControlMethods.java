package mobile.config.base.methods;

import mobile.config.base.impl.Condition;
import org.openqa.selenium.WebElement;

public interface WebElementControlMethods {
    WebElement shouldBe(Condition condition);
    WebElement shouldBe(Condition condition, int time);
    WebElement shouldBe(Condition ...conditions);
}
