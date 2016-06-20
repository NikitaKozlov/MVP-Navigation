package org.kaerdan.mvp_navigation.example2_fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.article.ArticleFragment;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;

public class FragmentsNavigator implements ArticleListContract.Navigator{

    private final AppCompatActivity activity;

    public FragmentsNavigator(AppCompatActivity activity) {
        this.activity = activity;

    }

    @Override
    public void openArticle(int id) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.secondary_content, ArticleFragment.newInstance(id), null)
                .commit();
    }

    @Override
    public void openFavoriteArticles() {
        activity.startActivity(new Intent(activity, FavoriteListActivity.class));
    }

}
