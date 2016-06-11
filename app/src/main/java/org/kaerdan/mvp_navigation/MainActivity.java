package org.kaerdan.mvp_navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ListView listView;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.button_list);
        mainPresenter = new MainPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.onAttachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.onDetachView();
    }

    @Override
    public void displayButtons(List<Integer> stringIdList) {
        listView.setAdapter(new ArrayAdapter<Integer>(this, 0, stringIdList) {
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                Button button = convertView != null ? (Button) convertView : new Button(parent.getContext());
                button.setText(getItem(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mainPresenter.onButtonFromListClicked(position);
                    }
                });
                return button;
            }
        });
    }

    @Override
    public void launchActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

}
