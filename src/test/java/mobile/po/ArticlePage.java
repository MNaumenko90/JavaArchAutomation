package mobile.po;

import mobile.config.base.impl.BaseMethods;
import org.openqa.selenium.By;

import static mobile.config.base.impl.Condition.clickable;
import static mobile.config.base.impl.Condition.visible;

public class ArticlePage extends BaseMethods {

    private final By firstArticle =
            By.xpath("//*[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup[1]");
    private final By articleName = By.xpath("(//android.widget.TextView[@text='Appium'])[1]");
    private final By photo = By.xpath("//android.widget.ImageView[@resource-id=\"org.wikipedia:id/view_page_header_image\"]");


    public ArticlePage clickFirstArticle() {
        element(firstArticle).shouldBe(visible, clickable).click();
        return new ArticlePage();
    }

    public String getArticleName() {
        return element(articleName).shouldBe(visible).getText();
    }

    public void downloadPicture() {
        getPhotoFromArticle(photo);
    }
}
