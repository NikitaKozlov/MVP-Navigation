package org.kaerdan.mvp_navigation.core.fragments.favorite_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;

public class FavoriteListPresenter implements FavoriteListContract.Presenter, OnArticleClickListener {

    private FavoriteListContract.View view;
    private FavoriteListContract.Navigator navigator;

    @Override
    public void onAttachView(FavoriteListContract.View view) {
        this.view = view;

        //Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getFavouriteArticles(), this);
    }

    @Override
    public void onDetachView() {
        this.view = null;
    }

    @Override
    public void onArticleClick(int id) {
        navigator.openArticle(id);
    }

    @Override
    public void setNavigator(FavoriteListContract.Navigator navigator) {
        this.navigator = navigator;
    }
}
