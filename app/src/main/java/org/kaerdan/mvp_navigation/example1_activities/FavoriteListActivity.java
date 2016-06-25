package org.kaerdan.mvp_navigation.example1_activities;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListContract;
import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListFragment;
import org.kaerdan.mvp_navigation.example2_fragments.FragmentsFavoriteListNavigator;

import android.os.Bundle;

import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;

public class FavoriteListActivity extends AppCompatActivity implements FavoriteListContract.NavigatorProvider {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.content_frame, new FavoriteListFragment(), null)
                                       .commit();
        }
    }

    @NonNull
    @Override
    public FavoriteListContract.Navigator getNavigator(final FavoriteListContract.Presenter presenter) {
        return new FragmentsFavoriteListNavigator(this);
    }

}
