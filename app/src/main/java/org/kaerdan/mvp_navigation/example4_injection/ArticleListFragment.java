package org.kaerdan.mvp_navigation.example4_injection;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListAdapter;

import java.util.List;


public class ArticleListFragment extends Fragment implements ArticleListContract.View {

    //@Inject
    ArticleListContract.Presenter presenter;

    private RecyclerView recyclerView;

    public ArticleListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.article_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),
                LinearLayoutManager.VERTICAL, false));

        Injector.inject(this);

        view.findViewById(R.id.favorite_articles)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onFavoriteArticleClick();
                    }
                });

        return view;
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
    public void displayArticles(List<Article> articles, OnArticleClickListener onArticleClickListener) {
        recyclerView.setAdapter(new ArticleListAdapter(articles, onArticleClickListener));
    }
}
