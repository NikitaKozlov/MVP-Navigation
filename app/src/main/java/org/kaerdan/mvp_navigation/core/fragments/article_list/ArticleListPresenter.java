package org.kaerdan.mvp_navigation.core.fragments.article_list;

import org.kaerdan.mvp_navigation.core.data.DataProvider;

public class ArticleListPresenter implements ArticleListContract.Presenter, OnArticleClickListener {

    private ArticleListContract.View view;
    private ArticleListNavigationContract.Navigator navigator;

    @Override
    public void onAttachView(ArticleListContract.View view) {
        this.view = view;

        //Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getArticles(), this);
    }

    public void setNavigator(ArticleListNavigationContract.Navigator navigator) {
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
    public void onArticleClick(int id) {
        navigator.openArticle(id);
    }
}
