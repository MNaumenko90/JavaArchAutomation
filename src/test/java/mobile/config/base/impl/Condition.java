package mobile.config.base.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static mobile.utils.Util.f;

public enum Condition {
    visible {
        @Override
        protected WebElement waitElement(By by, WebDriverWait waiter) {
            return waiter
                    .withMessage(f("The element - %s is not found", by))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
    },
    clickable {
        @Override
        protected WebElement waitElement(By by, WebDriverWait waiter) {
            return waiter
                    .withMessage(f("The element - %s is not clickable", by))
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
    };

    protected abstract WebElement waitElement(By by, WebDriverWait waiter);

}
