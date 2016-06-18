package org.kaerdan.mvp_navigation.core.fragments.article_list;

import android.support.annotation.NonNull;

import org.kaerdan.mvp_navigation.core.data.Article;

import java.util.List;

public interface ArticleListContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> {
        void setNavigator(Navigator navigator);

        void onFavoriteArticleClick();
    }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayArticles(List<Article> articles, OnArticleClickListener onArticleClickListener);
    }

    interface Navigator {
        void openArticle(int id);

        void openFavoriteArticles();
    }

    interface NavigatorProvider {

        @NonNull
        Navigator getNavigator(ArticleListContract.Presenter presenter);
    }
}
