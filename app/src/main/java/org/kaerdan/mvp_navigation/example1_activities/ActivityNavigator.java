package org.kaerdan.mvp_navigation.example1_activities;

import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListContract;

import android.content.Context;
import android.content.Intent;

public class ActivityNavigator implements ArticleListContract.Navigator {

    private final Context activityContext;

    public ActivityNavigator(final Context activityContext) {
        this.activityContext = activityContext;
    }

    @Override
    public void openArticle(final int id) {
        activityContext.startActivity(ArticleActivity.createIntent(activityContext, id));
    }

    @Override
    public void openFavoriteArticles() {
        activityContext.startActivity(new Intent(activityContext, FavoriteListActivity.class));
    }
}
