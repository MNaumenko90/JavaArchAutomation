package mobile.services;

import mobile.po.ArticlePage;

public class ArticleService {

    private final ArticlePage articlePage = new ArticlePage();

    public String getArticleName() {
        return articlePage
                .clickFirstArticle()

                .getArticleName();
    }

    public void clickArticleAndSaveImage() {
        articlePage
                .clickFirstArticle()
                .downloadPicture();
    }

    public void clickArticle() {
        articlePage
                .clickFirstArticle();
    }
}
