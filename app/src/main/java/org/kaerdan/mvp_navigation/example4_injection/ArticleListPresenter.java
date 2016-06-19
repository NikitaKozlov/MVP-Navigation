package org.kaerdan.mvp_navigation.example4_injection;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;

public class ArticleListPresenter implements ArticleListContract.Presenter, OnArticleClickListener {

    private ArticleListContract.View view;

    //@Inject
    ArticleListContract.Navigator navigator;

    @Override
    public void onAttachView(ArticleListContract.View view) {
        this.view = view;

        //Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getArticles(), this);
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
