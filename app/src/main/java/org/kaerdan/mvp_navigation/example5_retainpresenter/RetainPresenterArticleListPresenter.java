package org.kaerdan.mvp_navigation.example5_retainpresenter;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import android.support.annotation.NonNull;

public class RetainPresenterArticleListPresenter implements RetainPresenterArticleListContract.Presenter,
    OnArticleClickListener {

    private RetainPresenterArticleListContract.View mView;
    private RetainPresenterArticleListContract.Navigator mNavigator;

    @Override
    public void onAttachView(final RetainPresenterArticleListContract.View view) {
        this.mView = view;

        // Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getArticles(), this);
    }

    public void setNavigator(@NonNull final RetainPresenterArticleListContract.Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Override
    public void onFavoriteArticleClick() {
        mNavigator.openFavoriteArticles();
    }

    @Override
    public void onDetachView() {
        mView = null;
        mNavigator = null;
    }

    @Override
    public void onDestroy() { }

    @Override
    public void onArticleClick(final int id) {
        mNavigator.openArticle(id);
    }
}
