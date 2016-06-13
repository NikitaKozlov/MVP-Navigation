package org.kaerdan.mvp_navigation.core.fragments.article;

import org.kaerdan.mvp_navigation.core.data.Article;

public interface ArticleContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> {
    }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayArticle(Article article);
    }
}
