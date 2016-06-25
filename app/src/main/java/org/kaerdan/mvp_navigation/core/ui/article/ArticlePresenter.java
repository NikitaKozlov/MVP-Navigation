package org.kaerdan.mvp_navigation.core.ui.article;

import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.data.DataProvider;

public class ArticlePresenter implements ArticleContract.Presenter {

    private final int mArticleId;
    private ArticleContract.View mView;

    public ArticlePresenter(final int articleId) {
        this.mArticleId = articleId;
    }

    @Override
    public void onAttachView(final ArticleContract.View view) {
        this.mView = view;

        // Usually this call goes asynchronous but for this example it doesn't matter
        Article article = DataProvider.getInstance().getArticleById(mArticleId);

        if (article != null) {
            view.displayArticle(article);
        } else {
            // Show error screen, or snack bar.
        }

    }

    @Override
    public void onDetachView() {
        mView = null;
    }
}
