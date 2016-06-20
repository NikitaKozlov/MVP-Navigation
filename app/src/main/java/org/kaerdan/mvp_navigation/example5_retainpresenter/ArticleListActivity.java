package org.kaerdan.mvp_navigation.example5_retainpresenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.presenterretainer.PresenterActivity;

public class ArticleListActivity extends PresenterActivity implements ArticleListContract.NavigatorProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_frame, new ArticleListFragment(), null)
                    .commit();
        }
    }

    @NonNull
    @Override
    public ArticleListContract.Navigator getNavigator(ArticleListContract.Presenter presenter) {
        return new ActivityNavigator(this);
    }
}