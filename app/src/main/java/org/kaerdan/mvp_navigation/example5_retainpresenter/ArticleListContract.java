package org.kaerdan.mvp_navigation.example5_retainpresenter;

import android.support.annotation.NonNull;

import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;

import java.util.List;

public interface ArticleListContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void setNavigator(Navigator navigator);

        void onFavoriteArticleClick();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
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
