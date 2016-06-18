package org.kaerdan.mvp_navigation.example1_activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListContract;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListFragment;

public class FavoriteListActivity extends AppCompatActivity
        implements FavoriteListContract.NavigatorProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_frame, new FavoriteListFragment(), null)
                    .commit();
        }
    }

    @NonNull
    @Override
    public FavoriteListContract.Navigator getNavigator(FavoriteListContract.Presenter presenter) {
        return new FavoriteListContract.Navigator() {
            @Override
            public void openArticle(int id) {
                startActivity(ArticleActivity.createIntent(FavoriteListActivity.this, id));
            }
        };
    }

}