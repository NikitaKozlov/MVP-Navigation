package org.kaerdan.mvp_navigation.example2_fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.article.ArticleFragment;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListContract;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListFragment;

public class FavoriteListActivity extends AppCompatActivity implements FavoriteListContract.NavigatorProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_content, new FavoriteListFragment(), null)
                    .commit();
        }
    }

    @NonNull
    @Override
    public FavoriteListContract.Navigator getNavigator(FavoriteListContract.Presenter presenter) {
        return new FavoriteListContract.Navigator() {
            @Override
            public void openArticle(int id) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.secondary_content, ArticleFragment.newInstance(id), null)
                        .commit();
            }
        };
    }
}