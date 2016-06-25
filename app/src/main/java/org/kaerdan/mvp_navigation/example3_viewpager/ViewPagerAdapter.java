package org.kaerdan.mvp_navigation.example3_viewpager;

import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListFragment;
import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {
        if (position == 0) {
            return new ArticleListFragment();
        }
        return new FavoriteListFragment();
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        if (position == 0) {
            return "Article List";
        }
        return "Favorite List";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
