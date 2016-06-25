package org.kaerdan.mvp_navigation.example3_viewpager;

import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;

import android.content.Context;

import android.support.v4.view.ViewPager;

public class ViewPagerArticleListNavigator implements ArticleListContract.Navigator {

    private final Context mActivityContext;
    private final ViewPager mViewPager;

    public ViewPagerArticleListNavigator(final Context mActivityContext, final ViewPager mViewPager) {
        this.mActivityContext = mActivityContext;
        this.mViewPager = mViewPager;
    }

    @Override
    public void openArticle(final int id) {
        mActivityContext.startActivity(ArticleActivity.createIntent(mActivityContext, id));
    }

    @Override
    public void openFavoriteArticles() {
        mViewPager.setCurrentItem(1);
    }
}
