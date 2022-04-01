package org.kaerdan.mvp_navigation.core.ui.article;

import org.kaerdan.mvp_navigation.core.data.Article;

import androidx.annotation.NonNull;

public interface ArticleContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> { }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayArticle(@NonNull Article article);
    }
}
