package org.kaerdan.mvp_navigation.core.data;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    private static final Article ARTICLE_1 = new Article(1, "Article 1", "Article 1 body", false);
    private static final Article ARTICLE_2 = new Article(2, "Article 2", "Article 2 body", true);
    private static final Article ARTICLE_3 = new Article(3, "Article 3", "Article 3 body", false);
    private static final Article ARTICLE_4 = new Article(4, "Article 4", "Article 4 body", true);
    private static final Article ARTICLE_5 = new Article(5, "Article 5", "Article 5 body", false);
    private static final Article ARTICLE_6 = new Article(6, "Article 6", "Article 6 body", true);
    private static final Article ARTICLE_7 = new Article(7, "Article 7", "Article 7 body", false);
    private static final Article ARTICLE_8 = new Article(8, "Article 8", "Article 8 body", true);
    private static final Article ARTICLE_9 = new Article(9, "Article 9", "Article 9 body", false);
    private static final Article ARTICLE_10 = new Article(10, "Article 10", "Article 10 body", true);

    private static DataProvider ourInstance = new DataProvider();

    public static DataProvider getInstance() {
        return ourInstance;
    }

    private final List<Article> articles;

    private DataProvider() {
        articles = Arrays.asList(ARTICLE_1, ARTICLE_2, ARTICLE_3, ARTICLE_4, ARTICLE_5, ARTICLE_6,
                ARTICLE_7, ARTICLE_8, ARTICLE_9, ARTICLE_10);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Article> getFavouriteArticles() {
        List<Article> favouriteArticles = new ArrayList<>();
        for (Article article : articles) {
            if (article.isFavourite()) {
                favouriteArticles.add(article);
            }
        }
        return favouriteArticles;
    }

    @Nullable
    public Article getArticleById(int id) {
        for (Article article : articles) {
            if (id == article.getId()) {
                return article;
            }
        }
        return null;
    }
}
