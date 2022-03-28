package org.kaerdan.mvp_navigation.example4_injection;

import java.util.List;

import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import androidx.annotation.NonNull;

public interface InjectArticleListContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> {
        void onFavoriteArticleClick();
    }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayArticles(@NonNull List<Article> articles,
                             @NonNull OnArticleClickListener onArticleClickListener);
    }

    interface Navigator {
        void openArticle(int id);

        void openFavoriteArticles();
    }
}
