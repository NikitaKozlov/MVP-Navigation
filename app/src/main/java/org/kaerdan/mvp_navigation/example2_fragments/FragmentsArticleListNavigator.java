package org.kaerdan.mvp_navigation.example2_fragments;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.ui.article.ArticleFragment;
import org.kaerdan.mvp_navigation.core.ui.article_list.ArticleListContract;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentsArticleListNavigator implements ArticleListContract.Navigator {

    private final AppCompatActivity mActivity;

    public FragmentsArticleListNavigator(final AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Override
    public void openArticle(final int id) {
        mActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.secondary_content, ArticleFragment.newInstance(id), null)
                .commit();
    }

    @Override
    public void openFavoriteArticles() {
        mActivity.startActivity(new Intent(mActivity, FragmentsFavoriteListActivity.class));
    }

}
