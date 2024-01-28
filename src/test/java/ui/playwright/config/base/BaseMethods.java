package ui.playwright.config.base;

import com.microsoft.playwright.Locator;

import static ui.playwright.config.page.PageInit.getPage;

public class BaseMethods {

    protected void click(String locator) {
        getPage().locator(locator).click();
    }

    protected void forceClick(String locator) {
        getPage().locator(locator).click(new Locator.ClickOptions().setForce(true));
    }

    protected void send(String locator, String text) {
        getPage().locator(locator).fill(text);
    }

    protected void clear(String locator) {
        getPage().locator(locator).clear();
    }

    protected String getText(String locator) {
        return getPage().locator(locator).textContent();
    }
}
