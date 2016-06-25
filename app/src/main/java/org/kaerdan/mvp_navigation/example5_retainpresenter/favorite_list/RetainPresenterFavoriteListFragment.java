package org.kaerdan.mvp_navigation.example5_retainpresenter.favorite_list;

import java.util.List;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.fragments.ArticleListAdapter;
import org.kaerdan.mvp_navigation.core.fragments.OnArticleClickListener;

import org.kaerdan.presenterretainer.PresenterFragment;

import android.app.Activity;

import android.os.Bundle;

import android.support.annotation.NonNull;

import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RetainPresenterFavoriteListFragment
    extends PresenterFragment<RetainPresenterFavoriteListContract.Presenter, RetainPresenterFavoriteListContract.View>
    implements RetainPresenterFavoriteListContract.View {

    private RecyclerView mRecyclerView;

    public RetainPresenterFavoriteListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_favorite_article_list, container, false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL,
                false));
        return mRecyclerView;
    }

    @Override
    protected void onPresenterRestored() {
        super.onPresenterRestored();

        RetainPresenterFavoriteListContract.Presenter presenter = getPresenter();
        presenter.setNavigator(getNavigator(presenter));
    }

    @NonNull
    protected RetainPresenterFavoriteListContract.Presenter onCreatePresenter() {
        RetainPresenterFavoriteListContract.Presenter presenter = new RetainPresenterFavoriteListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @Override
    protected RetainPresenterFavoriteListContract.View getPresenterView() {
        return this;
    }

    @NonNull
    protected RetainPresenterFavoriteListContract.Navigator getNavigator(
            final RetainPresenterFavoriteListContract.Presenter presenter) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof RetainPresenterFavoriteListContract.NavigatorProvider) {
            return ((RetainPresenterFavoriteListContract.NavigatorProvider) parentFragment).getNavigator(presenter);
        } else {
            Activity activity = getActivity();
            if (activity instanceof RetainPresenterFavoriteListContract.NavigatorProvider) {
                return ((RetainPresenterFavoriteListContract.NavigatorProvider) activity).getNavigator(presenter);
            }
        }

        throw new IllegalStateException("Activity or parent Fragment must implement "
                + "RetainPresenterFavoriteListContract.NavigatorProvider");
    }

    @Override
    public void displayArticles(@NonNull final List<Article> articles,
            @NonNull final OnArticleClickListener onArticleClickListener) {
        mRecyclerView.setAdapter(new ArticleListAdapter(articles, onArticleClickListener));
    }
}
