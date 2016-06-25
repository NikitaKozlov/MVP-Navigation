package org.kaerdan.mvp_navigation.core.ui.favorite_list;

import java.util.List;

import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import android.support.annotation.NonNull;

public interface FavoriteListContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> {
        void setNavigator(Navigator navigator);
    }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayArticles(List<Article> articles, OnArticleClickListener onArticleClickListener);
    }

    interface Navigator {
        void openArticle(int id);
    }

    interface NavigatorProvider {

        @NonNull
        Navigator getNavigator(FavoriteListContract.Presenter presenter);
    }
}
