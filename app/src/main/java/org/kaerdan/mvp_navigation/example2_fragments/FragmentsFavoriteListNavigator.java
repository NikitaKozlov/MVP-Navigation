package org.kaerdan.mvp_navigation.example2_fragments;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.ui.article.ArticleFragment;
import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListContract;

import android.support.v7.app.AppCompatActivity;

public class FragmentsFavoriteListNavigator implements FavoriteListContract.Navigator {

    private final AppCompatActivity mActivity;

    public FragmentsFavoriteListNavigator(final AppCompatActivity activity) {
        this.mActivity = activity;

    }

    @Override
    public void openArticle(final int id) {
        mActivity.getSupportFragmentManager().beginTransaction()
                 .replace(R.id.secondary_content, ArticleFragment.newInstance(id), null).commit();
    }
}
