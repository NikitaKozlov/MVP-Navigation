package org.kaerdan.mvp_navigation.example1_activities;

import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListContract;

import android.content.Context;
import android.content.Intent;

public class ActivitiesArticleListNavigator implements ArticleListContract.Navigator {

    private final Context mActivityContext;

    public ActivitiesArticleListNavigator(final Context activityContext) {
        this.mActivityContext = activityContext;
    }

    @Override
    public void openArticle(final int id) {
        mActivityContext.startActivity(ArticleActivity.createIntent(mActivityContext, id));
    }

    @Override
    public void openFavoriteArticles() {
        mActivityContext.startActivity(new Intent(mActivityContext, FavoriteListActivity.class));
    }
}
