package org.kaerdan.mvp_navigation.example3_viewpager;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListFragment;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListContract;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListFragment;
import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;

public class ArticleViewPagerActivity extends AppCompatActivity
        implements ArticleListContract.NavigatorProvider,
        FavoriteListContract.NavigatorProvider {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @NonNull
    @Override
    public ArticleListContract.Navigator getNavigator(ArticleListContract.Presenter presenter) {
        return new ArticleListContract.Navigator() {
            @Override
            public void openArticle(int id) {
                startActivity(ArticleActivity.createIntent(ArticleViewPagerActivity.this, id));
            }

            @Override
            public void openFavoriteArticles() {
                mViewPager.setCurrentItem(1);
            }
        };
    }

    @NonNull
    @Override
    public FavoriteListContract.Navigator getNavigator(FavoriteListContract.Presenter presenter) {
        return new FavoriteListContract.Navigator() {
            @Override
            public void openArticle(int id) {
                startActivity(ArticleActivity.createIntent(ArticleViewPagerActivity.this, id));
            }
        };
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ArticleListFragment();
            }
            return new FavoriteListFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
