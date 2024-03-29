package org.kaerdan.mvp_navigation.example3_viewpager;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListContract;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.tabs.TabLayout;

public class ViewPagerActivity extends AppCompatActivity implements ArticleListContract.NavigatorProvider,
    FavoriteListContract.NavigatorProvider {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        ((TabLayout) findViewById(R.id.tabs)).setupWithViewPager(mViewPager);
    }

    @NonNull
    @Override
    public ArticleListContract.Navigator getNavigator(final ArticleListContract.Presenter presenter) {
        return new ViewPagerArticleListNavigator(this, mViewPager);
    }

    @NonNull
    @Override
    public FavoriteListContract.Navigator getNavigator(final FavoriteListContract.Presenter presenter) {
        return new ViewPagerFavoriteListNavigator(this);
    }
}
