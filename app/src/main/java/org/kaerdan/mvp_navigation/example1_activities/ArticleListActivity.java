package org.kaerdan.mvp_navigation.example1_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListFragment;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListNavigationContract;

public class ArticleListActivity extends AppCompatActivity implements ArticleListNavigationContract.NavigatorProvider {

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
    public ArticleListNavigationContract.Navigator getNavigator(ArticleListContract.Presenter presenter) {
        return new ArticleListNavigationContract.Navigator() {
            @Override
            public void openArticle(int id) {
                startActivity(ArticleActivity.createIntent(ArticleListActivity.this, id));
            }

            @Override
            public void openFavoriteArticles() {
                startActivity(new Intent(ArticleListActivity.this, FavoriteArticleListActivity.class));
            }
        };
    }
}