package ui.selenide.js;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JSActions {

    public static void jsClick(SelenideElement element) {
        executeJavaScript("arguments[0].click()", element);
    }

    public static void jsScroll(SelenideElement element) {
        executeJavaScript("arguments[0].scrollIntoView(true);", element);
    }

    public static boolean isScrolled(SelenideElement element) {
        return Boolean.TRUE.equals(executeJavaScript("var elem = arguments[0]," +
                "  box = elem.getBoundingClientRect(),    " +
                "  cx = box.left + box.width / 2,         " +
                "  cy = box.top + box.height / 2,         " +
                "  e = document.elementFromPoint(cx, cy); " +
                "for (; e; e = e.parentElement) {         " +
                "  if (e === elem)                        " +
                "    return true;                         " +
                "}                                        " +
                "return false;                            ", element));
    }

}
