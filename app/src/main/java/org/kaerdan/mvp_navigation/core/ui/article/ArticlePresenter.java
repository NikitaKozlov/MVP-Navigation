package org.kaerdan.mvp_navigation.core.ui.article;

import org.kaerdan.mvp_navigation.core.data.DataProvider;

public class ArticlePresenter implements ArticleContract.Presenter {

    private final int id;
    private ArticleContract.View view;

    public ArticlePresenter(final int id) {
        this.id = id;
    }

    @Override
    public void onAttachView(final ArticleContract.View view) {
        this.view = view;

        // Usually this call goes asynchronous but for this example it doesn't matter
        view.displayArticle(DataProvider.getInstance().getArticleById(id));
    }

    @Override
    public void onDetachView() {
        view = null;
    }
}
