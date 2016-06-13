package org.kaerdan.mvp_navigation.core.fragments.favorite_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.fragments.article_list.OnArticleClickListener;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListNavigationContract;

public class FavoriteArticleListPresenter implements FavoriteArticleListContract.Presenter, OnArticleClickListener {

    private FavoriteArticleListContract.View view;
    private FavoriteArticleListNavigationContract.Navigator navigator;

    @Override
    public void onAttachView(FavoriteArticleListContract.View view) {
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
    public void setNavigator(FavoriteArticleListNavigationContract.Navigator navigator) {
        this.navigator = navigator;
    }
}
