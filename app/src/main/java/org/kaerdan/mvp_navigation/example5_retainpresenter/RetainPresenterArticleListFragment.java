package org.kaerdan.mvp_navigation.example5_retainpresenter;

import java.util.List;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.ui.ArticleListAdapter;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

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

public class RetainPresenterArticleListFragment
    extends PresenterFragment<RetainPresenterArticleListContract.Presenter, RetainPresenterArticleListContract.View>
    implements RetainPresenterArticleListContract.View {

    private RecyclerView mRecyclerView;

    public RetainPresenterArticleListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.article_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL,
                false));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getView().findViewById(R.id.favorite_articles).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    getPresenter().onFavoriteArticleClick();
                }
            });
    }

    @Override
    protected void onPresenterRestored() {
        super.onPresenterRestored();

        RetainPresenterArticleListContract.Presenter presenter = getPresenter();
        presenter.setNavigator(getNavigator(presenter));
    }

    @NonNull
    @Override
    protected RetainPresenterArticleListContract.Presenter onCreatePresenter() {
        RetainPresenterArticleListContract.Presenter presenter = new RetainPresenterArticleListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @Override
    protected RetainPresenterArticleListContract.View getPresenterView() {
        return this;
    }

    @NonNull
    protected RetainPresenterArticleListContract.Navigator getNavigator(
            final RetainPresenterArticleListContract.Presenter presenter) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof RetainPresenterArticleListContract.NavigatorProvider) {
            return ((RetainPresenterArticleListContract.NavigatorProvider) parentFragment).getNavigator(presenter);
        } else {
            Activity activity = getActivity();
            if (activity instanceof RetainPresenterArticleListContract.NavigatorProvider) {
                return ((RetainPresenterArticleListContract.NavigatorProvider) activity).getNavigator(presenter);
            }
        }

        throw new IllegalStateException("Activity or parent Fragment must implement "
                + "ArticleListNavigationContract.NavigatorProvider");
    }

    @Override
    public void displayArticles(@NonNull final List<Article> articles,
            @NonNull final OnArticleClickListener onArticleClickListener) {
        mRecyclerView.setAdapter(new ArticleListAdapter(articles, onArticleClickListener));
    }
}
