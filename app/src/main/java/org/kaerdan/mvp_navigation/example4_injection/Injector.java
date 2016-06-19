package org.kaerdan.mvp_navigation.example4_injection;

import android.content.Intent;

import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;
import org.kaerdan.mvp_navigation.example1_activities.FavoriteListActivity;

public class Injector {

    static void inject(final ArticleListFragment fragment) {
        ArticleListPresenter presenter = new ArticleListPresenter();
        presenter.navigator = new ArticleListContract.Navigator() {
            @Override
            public void openArticle(int id) {
                fragment.getActivity().startActivity(ArticleActivity.createIntent(
                        fragment.getContext(), id));
            }

            @Override
            public void openFavoriteArticles() {
                fragment.getActivity().startActivity(new Intent(fragment.getContext(), FavoriteListActivity.class));
            }
        };

        fragment.presenter = presenter;
    }
}
