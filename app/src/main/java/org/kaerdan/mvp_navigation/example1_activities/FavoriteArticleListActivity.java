package org.kaerdan.mvp_navigation.example1_activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListNavigationContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.FavoriteArticleListFragment;

public class FavoriteArticleListActivity extends AppCompatActivity implements ArticleListNavigationContract.NavigatorProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_frame, new FavoriteArticleListFragment(), null)
                    .commit();
        }
    }

    @NonNull
    @Override
    public ArticleListNavigationContract.Navigator getNavigator(ArticleListContract.Presenter presenter) {
        return new ArticleListNavigationContract.Navigator() {
            @Override
            public void openArticle(int id) {
                startActivity(ArticleActivity.createIntent(FavoriteArticleListActivity.this, id));
            }
        };
    }

}