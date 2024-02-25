package mobile.config.base.methods;

import org.openqa.selenium.support.ui.WebDriverWait;

public interface Waiter {
    WebDriverWait waiter(long timeOutSeconds);
}
