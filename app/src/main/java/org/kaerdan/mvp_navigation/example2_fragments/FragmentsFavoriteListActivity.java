package org.kaerdan.mvp_navigation.example2_fragments;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListContract;
import org.kaerdan.mvp_navigation.core.ui.favorite_list.FavoriteListFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

public class FragmentsFavoriteListActivity extends AppCompatActivity implements FavoriteListContract.NavigatorProvider {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_content, new FavoriteListFragment(), null)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public FavoriteListContract.Navigator getNavigator(final FavoriteListContract.Presenter presenter) {
        return new FragmentsFavoriteListNavigator(this);
    }
}
