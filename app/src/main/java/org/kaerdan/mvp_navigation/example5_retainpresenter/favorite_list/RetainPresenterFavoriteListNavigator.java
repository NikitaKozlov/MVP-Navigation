package org.kaerdan.mvp_navigation.example5_retainpresenter.favorite_list;

import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;

import android.content.Context;

public class RetainPresenterFavoriteListNavigator implements RetainPresenterFavoriteListContract.Navigator {

    private final Context mActivityContext;

    public RetainPresenterFavoriteListNavigator(final Context activityContext) {
        this.mActivityContext = activityContext;
    }

    @Override
    public void openArticle(final int id) {
        mActivityContext.startActivity(ArticleActivity.createIntent(mActivityContext, id));
    }
}
