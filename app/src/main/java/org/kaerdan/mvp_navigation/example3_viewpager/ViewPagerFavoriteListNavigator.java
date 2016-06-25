package org.kaerdan.mvp_navigation.example3_viewpager;

import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListContract;
import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;

import android.content.Context;

public class ViewPagerFavoriteListNavigator implements FavoriteListContract.Navigator {

    private final Context mActivityContext;

    public ViewPagerFavoriteListNavigator(final Context mActivityContext) {
        this.mActivityContext = mActivityContext;
    }

    @Override
    public void openArticle(final int id) {
        mActivityContext.startActivity(ArticleActivity.createIntent(mActivityContext, id));
    }
}
