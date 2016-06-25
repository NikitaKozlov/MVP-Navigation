package org.kaerdan.mvp_navigation.example5_retainpresenter.article_list;

import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;
import org.kaerdan.mvp_navigation.example5_retainpresenter.favorite_list.RetainPresenterFavoriteListActivity;

import android.content.Context;
import android.content.Intent;

public class RetainPresenterActivityNavigator implements RetainPresenterArticleListContract.Navigator {

    private final Context activityContext;

    public RetainPresenterActivityNavigator(final Context activityContext) {
        this.activityContext = activityContext;
    }

    @Override
    public void openArticle(final int id) {
        activityContext.startActivity(ArticleActivity.createIntent(activityContext, id));
    }

    @Override
    public void openFavoriteArticles() {
        activityContext.startActivity(new Intent(activityContext, RetainPresenterFavoriteListActivity.class));
    }
}
