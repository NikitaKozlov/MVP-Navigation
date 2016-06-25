package org.kaerdan.mvp_navigation.example4_injection;

import org.kaerdan.mvp_navigation.core.data.DataProvider;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

public class InjectArticleListPresenter implements InjectArticleListContract.Presenter, OnArticleClickListener {

    private InjectArticleListContract.View mView;

    // @Inject
    InjectArticleListContract.Navigator mNavigator;

    @Override
    public void onAttachView(final InjectArticleListContract.View view) {
        this.mView = view;

        // Usually this call goes asynchronous, but for this example it doesn't matter
        view.displayArticles(DataProvider.getInstance().getArticles(), this);
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
    public void onArticleClick(final int id) {
        mNavigator.openArticle(id);
    }
}
