package org.kaerdan.mvp_navigation.example4_injection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.kaerdan.mvp_navigation.R;

public class ArticleListActivity extends AppCompatActivity {

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
}