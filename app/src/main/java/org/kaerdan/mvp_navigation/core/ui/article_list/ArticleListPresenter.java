package org.kaerdan.mvp_navigation.core.ui.article_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import android.support.annotation.NonNull;

public class ArticleListPresenter implements ArticleListContract.Presenter, OnArticleClickListener {

    private ArticleListContract.View view;
    private ArticleListContract.Navigator navigator;

    @Override
    public void onAttachView(final ArticleListContract.View view) {
        this.view = view;

        // Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getmArticles(), this);
    }

    public void setNavigator(@NonNull final ArticleListContract.Navigator navigator) {
        this.navigator = navigator;
    }

    @Override
    public void onFavoriteArticleClick() {
        navigator.openFavoriteArticles();
    }

    @Override
    public void onDetachView() {
        view = null;
        navigator = null;
    }

    @Override
    public void onArticleClick(final int id) {
        navigator.openArticle(id);
    }
}
