package org.kaerdan.mvp_navigation.example4_injection;

import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;
import org.kaerdan.mvp_navigation.example1_activities.FavoriteListActivity;

import android.content.Context;
import android.content.Intent;

public class InjectActivityNavigator implements InjectArticleListContract.Navigator {

    private final Context mActivityContext;

    public InjectActivityNavigator(final Context activityContext) {
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
