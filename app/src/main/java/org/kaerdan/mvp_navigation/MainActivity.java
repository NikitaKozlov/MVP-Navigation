package org.kaerdan.mvp_navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ListView mListView;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.button_list);
        mMainPresenter = new MainPresenter();
        mMainPresenter.setNavigator(new MainNavigator(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mMainPresenter.onAttachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMainPresenter.onDetachView();
    }

    @Override
    public void displayButtons(@NonNull List<Integer> stringIdList) {
        mListView.setAdapter(new ArrayAdapter<Integer>(this, 0, stringIdList) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                Button button = convertView != null ? (Button) convertView : new Button(parent.getContext());
                button.setText(getItem(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mMainPresenter.onButtonFromListClicked(position);
                    }
                });
                return button;
            }
        });
    }
}
