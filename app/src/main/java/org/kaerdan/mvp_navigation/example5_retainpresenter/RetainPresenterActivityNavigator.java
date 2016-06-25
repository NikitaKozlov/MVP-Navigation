package org.kaerdan.mvp_navigation.example5_retainpresenter;

import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;
import org.kaerdan.mvp_navigation.example1_activities.FavoriteListActivity;

import android.content.Context;
import android.content.Intent;

public class RetainPresenterActivityNavigator implements RetainPresenterArticleListContract.Navigator {

    private final Context mActivityContext;

    public RetainPresenterActivityNavigator(final Context activityContext) {
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
