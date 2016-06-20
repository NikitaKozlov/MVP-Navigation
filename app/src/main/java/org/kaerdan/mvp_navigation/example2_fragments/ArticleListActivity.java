package org.kaerdan.mvp_navigation.example2_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListFragment;

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
        return new FragmentsNavigator(this);
    }
}