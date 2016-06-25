package org.kaerdan.mvp_navigation.example5_retainpresenter;

import org.kaerdan.mvp_navigation.R;

import org.kaerdan.presenterretainer.PresenterActivity;

import android.os.Bundle;

import android.support.annotation.NonNull;

public class RetainPresenterArticleListActivity extends PresenterActivity
    implements RetainPresenterArticleListContract.NavigatorProvider {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.content_frame, new RetainPresenterArticleListFragment(), null)
                                       .commit();
        }
    }

    @NonNull
    @Override
    public RetainPresenterArticleListContract.Navigator getNavigator(
            final RetainPresenterArticleListContract.Presenter presenter) {
        return new RetainPresenterActivityNavigator(this);
    }
}
