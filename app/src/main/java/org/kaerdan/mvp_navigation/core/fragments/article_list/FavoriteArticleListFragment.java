package org.kaerdan.mvp_navigation.core.fragments.article_list;

import android.support.annotation.NonNull;

public class FavoriteArticleListFragment extends ArticleListFragment {

    @NonNull
    @Override
    protected ArticleListContract.Presenter getPresenter() {
        return new FavouriteArticleListPresenter();
    }
}
