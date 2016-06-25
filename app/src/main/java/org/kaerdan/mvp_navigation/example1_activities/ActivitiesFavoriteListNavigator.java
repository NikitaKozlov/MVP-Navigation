package org.kaerdan.mvp_navigation.example1_activities;

import android.content.Context;

import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListContract;

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
