package ui.playwright.po;

import ui.playwright.config.base.BaseMethods;

public class DocumentationPage extends BaseMethods {

    private final String docsButton = "//a[@class='getStarted_Sjon']";
    private final String docsHeader = "//div[@class='theme-doc-markdown markdown']//h1";

    public void clickDocs() {
        click(docsButton);
    }

    public String getHeaderDocs() {
        return getText(docsHeader);
    }
}
