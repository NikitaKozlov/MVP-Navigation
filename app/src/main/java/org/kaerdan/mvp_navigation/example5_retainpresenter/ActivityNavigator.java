package org.kaerdan.mvp_navigation.example5_retainpresenter;

import android.content.Context;
import android.content.Intent;

import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;

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
