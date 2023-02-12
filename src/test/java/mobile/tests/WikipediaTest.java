package mobile.tests;

import io.qameta.allure.Description;
import mobile.config.Base;
import mobile.po.SafeListPageObject;
import mobile.po.SearchPageObject;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WikipediaTest extends Base {

    @Test
    @Description("Search text Appium in app Wiki")
    public void searchAppiumTextTest() {
        new SearchPageObject(driver)
                .clickSkipButton()
                .searchAppiumText();

        assertEquals("Automation for Apps", new SearchPageObject(driver).getSearchedArticle());
    }

    @Test
    @Description("Test for correct swiping to up")
    public void simpleSwipeTest() {
        new SearchPageObject(driver)
                .clickSkipButton()
                .searchAppiumText()
                .swipeToUp();
    }

    @Test
    @Description("Test for correct adding and deleting article in list")
    public void safeArticleToMyList() {
        new SearchPageObject(driver)
                .clickSkipButton()
                .searchAppiumText()
                .clickSearchedText();

        new SafeListPageObject(driver)
                .clickSaveButton()
                .clickAddToList()
                .fillNameList("list")
                .clickConfirmCreateNameToList()
                .clickViewList();

        assertEquals("Automation for Apps", new SearchPageObject(driver).getSearchedArticle());

        new SafeListPageObject(driver)
                .swipeArticleLeft()
                .clickMoreOptions()
                .clickDeleteButton()
                .clickConfirmDelete();
    }
}
