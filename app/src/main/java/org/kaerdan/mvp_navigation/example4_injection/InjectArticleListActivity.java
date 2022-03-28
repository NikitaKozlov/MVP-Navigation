package org.kaerdan.mvp_navigation.example4_injection;

import org.kaerdan.mvp_navigation.R;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class InjectArticleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_frame, new InjectArticleListFragment(), null)
                    .commit();
        }
    }
}
