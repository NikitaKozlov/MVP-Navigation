package org.kaerdan.mvp_navigation.example5_retainpresenter.favorite_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;

import android.support.annotation.NonNull;

public class RetainPresenterFavoriteListPresenter implements RetainPresenterFavoriteListContract.Presenter,
    OnArticleClickListener {

    private RetainPresenterFavoriteListContract.View mView;
    private RetainPresenterFavoriteListContract.Navigator mNavigator;

    @Override
    public void onAttachView(final RetainPresenterFavoriteListContract.View view) {
        this.mView = view;

        // Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getFavouriteArticles(), this);
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

    @Override
    public void setNavigator(@NonNull final RetainPresenterFavoriteListContract.Navigator navigator) {
        this.mNavigator = navigator;
    }
}
