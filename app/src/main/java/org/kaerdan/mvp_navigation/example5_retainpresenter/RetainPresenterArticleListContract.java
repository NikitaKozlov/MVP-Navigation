package org.kaerdan.mvp_navigation.example5_retainpresenter;

import java.util.List;

import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import android.support.annotation.NonNull;

public interface RetainPresenterArticleListContract {
    interface Presenter extends org.kaerdan.presenterretainer.Presenter<View> {
        void setNavigator(@NonNull Navigator navigator);

        void onFavoriteArticleClick();
    }

    interface View extends org.kaerdan.presenterretainer.Presenter.View {
        void displayArticles(@NonNull List<Article> articles, @NonNull OnArticleClickListener onArticleClickListener);
    }

    interface Navigator {
        void openArticle(int id);

        void openFavoriteArticles();
    }

    interface NavigatorProvider {

        @NonNull
        Navigator getNavigator(RetainPresenterArticleListContract.Presenter presenter);
    }
}
