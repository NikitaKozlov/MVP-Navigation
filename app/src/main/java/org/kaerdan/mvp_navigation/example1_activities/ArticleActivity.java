package org.kaerdan.mvp_navigation.example1_activities;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.ui.article.ArticleFragment;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

public class ArticleActivity extends AppCompatActivity {

    private static final String ARTICLE_ID_TAG = "Article id";

    public static Intent createIntent(final Context context, final int id) {
        Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra(ARTICLE_ID_TAG, id);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.content_frame,
                ArticleFragment.newInstance(getIntent().getIntExtra(ARTICLE_ID_TAG, 0)), null).commit();
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
