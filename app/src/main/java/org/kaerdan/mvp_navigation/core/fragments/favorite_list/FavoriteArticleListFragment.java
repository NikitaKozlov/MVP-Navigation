package org.kaerdan.mvp_navigation.core.fragments.favorite_list;

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
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListAdapter;
import org.kaerdan.mvp_navigation.core.fragments.article_list.OnArticleClickListener;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListContract;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListNavigationContract;

import java.util.List;

public class FavoriteArticleListFragment extends Fragment implements FavoriteArticleListContract.View {

    private FavoriteArticleListContract.Presenter presenter;

    private RecyclerView recyclerView;

    public FavoriteArticleListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = getPresenter();
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_favorite_article_list, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),
                LinearLayoutManager.VERTICAL, false));
        return recyclerView;
    }


    @NonNull
    protected FavoriteArticleListContract.Presenter getPresenter() {
        FavoriteArticleListContract.Presenter presenter = new FavoriteArticleListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @NonNull
    protected FavoriteArticleListNavigationContract.Navigator getNavigator(FavoriteArticleListContract.Presenter presenter) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof FavoriteArticleListNavigationContract.NavigatorProvider) {
            return ((FavoriteArticleListNavigationContract.NavigatorProvider) parentFragment).getNavigator(presenter);
        } else {
            Activity activity = getActivity();
            if (activity instanceof FavoriteArticleListNavigationContract.NavigatorProvider) {
                return ((FavoriteArticleListNavigationContract.NavigatorProvider) activity).getNavigator(presenter);
            }
        }
        throw new IllegalStateException("Activity or parent Fragment must implement " +
                "FavoriteArticleListNavigationContract.NavigatorProvider");
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
