package org.kaerdan.mvp_navigation.core.fragments.article_list;

import android.support.annotation.NonNull;

public interface ArticleListNavigationContract {
    interface Navigator {
        void openArticle(int id);

        void openFavoriteArticles();
    }

    interface NavigatorProvider {

        @NonNull
        Navigator getNavigator(ArticleListContract.Presenter presenter);
    }
}
