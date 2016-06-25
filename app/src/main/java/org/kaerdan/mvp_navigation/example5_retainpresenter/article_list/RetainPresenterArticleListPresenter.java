package org.kaerdan.mvp_navigation.example5_retainpresenter.article_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;

import android.support.annotation.NonNull;

public class RetainPresenterArticleListPresenter implements RetainPresenterArticleListContract.Presenter,
    OnArticleClickListener {

    private RetainPresenterArticleListContract.View view;
    private RetainPresenterArticleListContract.Navigator navigator;

    @Override
    public void onAttachView(final RetainPresenterArticleListContract.View view) {
        this.view = view;

        // Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getArticles(), this);
    }

    public void setNavigator(@NonNull final RetainPresenterArticleListContract.Navigator navigator) {
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
    public void onDestroy() { }

    @Override
    public void onArticleClick(final int id) {
        navigator.openArticle(id);
    }
}
