package mobile.tests;

import mobile.config.Base;
import mobile.po.SafeListPageObject;
import mobile.po.SearchPageObject;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class WikipediaTest extends Base {

    @Test
    public void firstTest() {
        new SearchPageObject(driver)
                .clickSkipButton()
                .searchAppiumText();

        assertEquals("Automation for Apps", new SearchPageObject(driver).getSearchedArticle());
    }

    @Test
    public void simpleSwipeTest() {
        new SearchPageObject(driver)
                .clickSkipButton()
                .searchAppiumText()
                .swipeToUp();
    }

    @Test
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
