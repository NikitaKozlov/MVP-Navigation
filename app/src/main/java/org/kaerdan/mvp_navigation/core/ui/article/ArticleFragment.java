package org.kaerdan.mvp_navigation.core.ui.article;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;

import android.os.Bundle;

import android.support.annotation.NonNull;

import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class ArticleFragment extends Fragment implements ArticleContract.View {

    private static final String ARTICLE_ID_TAG = "Article id";

    public static ArticleFragment newInstance(final int id) {
        Bundle args = new Bundle();
        args.putInt(ARTICLE_ID_TAG, id);

        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private ArticleContract.Presenter mPresenter;
    private TextView mArticleTextView;

    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mPresenter = new ArticlePresenter(getArguments().getInt(ARTICLE_ID_TAG));

        View v = inflater.inflate(R.layout.fragment_article, container, false);
        mArticleTextView = (TextView) v.findViewById(R.id.article_body);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onAttachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onDetachView();
    }

    @Override
    public void displayArticle(@NonNull final Article article) {
        mArticleTextView.setText(article.getBody());
    }
}
