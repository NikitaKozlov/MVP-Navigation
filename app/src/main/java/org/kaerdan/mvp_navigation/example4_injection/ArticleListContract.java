package org.kaerdan.mvp_navigation.example4_injection;

import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;

import java.util.List;

public interface ArticleListContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> {
        void onFavoriteArticleClick();
    }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayArticles(List<Article> articles, OnArticleClickListener onArticleClickListener);
    }

    interface Navigator {
        void openArticle(int id);

        void openFavoriteArticles();
    }
}
