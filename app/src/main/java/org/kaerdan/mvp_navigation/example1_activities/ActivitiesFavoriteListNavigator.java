package org.kaerdan.mvp_navigation.example1_activities;

import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListContract;

import android.content.Context;

public class ActivitiesFavoriteListNavigator implements FavoriteListContract.Navigator {

    private final Context mActivityContext;

    public ActivitiesFavoriteListNavigator(final Context activityContext) {
        this.mActivityContext = activityContext;
    }

    @Override
    public void openArticle(final int id) {
        mActivityContext.startActivity(ArticleActivity.createIntent(mActivityContext, id));
    }
}
