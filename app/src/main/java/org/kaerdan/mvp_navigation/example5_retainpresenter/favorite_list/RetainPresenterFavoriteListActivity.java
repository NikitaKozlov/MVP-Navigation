package org.kaerdan.mvp_navigation.example5_retainpresenter.favorite_list;

import org.kaerdan.mvp_navigation.R;

import org.kaerdan.presenterretainer.PresenterActivity;

import android.os.Bundle;

import android.support.annotation.NonNull;

public class RetainPresenterFavoriteListActivity extends PresenterActivity
    implements RetainPresenterFavoriteListContract.NavigatorProvider {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.content_frame, new RetainPresenterFavoriteListFragment(), null)
                                       .commit();
        }
    }

    @NonNull
    @Override
    public RetainPresenterFavoriteListContract.Navigator getNavigator(
            final RetainPresenterFavoriteListContract.Presenter presenter) {
        return new RetainPresenterFavoriteListNavigator(this);
    }

}
