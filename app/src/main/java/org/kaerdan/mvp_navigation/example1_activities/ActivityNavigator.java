package org.kaerdan.mvp_navigation.example1_activities;

import android.content.Context;
import android.content.Intent;

import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;

public class ActivityNavigator implements ArticleListContract.Navigator {

    private final Context activityContext;

    public ActivityNavigator(Context activityContext) {
        this.activityContext = activityContext;
    }

    @Override
    public void openArticle(int id) {
        activityContext.startActivity(ArticleActivity.createIntent(activityContext, id));
    }

    @Override
    public void openFavoriteArticles() {
        activityContext.startActivity(new Intent(activityContext, FavoriteListActivity.class));
    }
}
