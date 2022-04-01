package org.kaerdan.mvp_navigation.core.ui.favorite_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import androidx.annotation.NonNull;

public class FavoriteListPresenter implements FavoriteListContract.Presenter, OnArticleClickListener {

    private FavoriteListContract.View view;
    private FavoriteListContract.Navigator navigator;

    @Override
    public void onAttachView(final FavoriteListContract.View view) {
        this.view = view;

        // Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getFavouriteArticles(), this);
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public void onArticleClick(final int id) {
        navigator.openArticle(id);
    }

    @Override
    public void setNavigator(@NonNull final FavoriteListContract.Navigator navigator) {
        this.navigator = navigator;
    }
}
