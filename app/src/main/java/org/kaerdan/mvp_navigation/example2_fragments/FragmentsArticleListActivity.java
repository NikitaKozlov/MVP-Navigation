package org.kaerdan.mvp_navigation.example2_fragments;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentsArticleListActivity extends AppCompatActivity implements ArticleListContract.NavigatorProvider {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_content, new ArticleListFragment(), null)
                    .commit();
        }
    }

    @NonNull
    @Override
    public ArticleListContract.Navigator getNavigator(final ArticleListContract.Presenter presenter) {
        return new FragmentsArticleListNavigator(this);
    }
}
