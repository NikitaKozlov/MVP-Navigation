package org.kaerdan.mvp_navigation.example2_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.article.ArticleFragment;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListFragment;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListContract;
import org.kaerdan.mvp_navigation.core.fragments.favorite_list.FavoriteListFragment;

public class ArticleListActivity extends AppCompatActivity implements ArticleListContract.NavigatorProvider {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_content, new ArticleListFragment(), null)
                    .commit();
        }
    }

    @NonNull
    @Override
    public ArticleListContract.Navigator getNavigator(ArticleListContract.Presenter presenter) {
        return new ArticleListContract.Navigator() {
            @Override
            public void openArticle(int id) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.secondary_content, ArticleFragment.newInstance(id), null)
                        .commit();
            }

            @Override
            public void openFavoriteArticles() {
                startActivity(new Intent(ArticleListActivity.this, FavoriteListActivity.class));
            }
        };
    }
}