package org.kaerdan.mvp_navigation.example5_retainpresenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.example1_activities.ArticleActivity;
import org.kaerdan.presenterretainer.PresenterActivity;

public class FavoriteListActivity extends PresenterActivity
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