package org.kaerdan.mvp_navigation.core.fragments.favorite_list;

import android.support.annotation.NonNull;

import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;

public interface FavoriteArticleListNavigationContract {
    interface Navigator {
        void openArticle(int id);
    }

    interface NavigatorProvider {

        @NonNull
        Navigator getNavigator(FavoriteArticleListContract.Presenter presenter);
    }
}
