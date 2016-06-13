package org.kaerdan.mvp_navigation.core.fragments.article;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;

public class ArticleFragment extends Fragment implements ArticleContract.View {

    private static final String ARTICLE_ID_TAG = "Article id";

    public static ArticleFragment newInstance(int id) {
        Bundle args = new Bundle();
        args.putInt(ARTICLE_ID_TAG, id);
        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ArticleContract.Presenter presenter;
    private TextView articleTextView;

    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        presenter = new ArticlePresenter(getArguments().getInt(ARTICLE_ID_TAG));
        View v = inflater.inflate(R.layout.fragment_article, container, false);
        articleTextView = (TextView) v.findViewById(R.id.article_body);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onAttachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onDetachView();
    }

    @Override
    public void displayArticle(Article article) {
        articleTextView.setText(article.getBody());
    }
}
