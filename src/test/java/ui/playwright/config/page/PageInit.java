package ui.playwright.config.page;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageInit {

    private static volatile Browser browser;
    private static volatile Playwright playwright;
    private static volatile Page page;

    private PageInit() {}

    public static synchronized Page getPage() {
        if (browser == null) {
            synchronized (PageInit.class) {
                if (browser == null) {
                    playwright = Playwright.create();
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page = browser.newPage();
                }
            }
        }
        return page;
    }

    public static void quit() {
        browser.close();
        playwright.close();
        playwright = null;
        browser = null;
    }
}
