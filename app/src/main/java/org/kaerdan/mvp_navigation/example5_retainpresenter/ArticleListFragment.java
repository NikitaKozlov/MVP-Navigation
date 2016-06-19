package org.kaerdan.mvp_navigation.example5_retainpresenter;

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
import org.kaerdan.mvp_navigation.core.fragments.ArticleListAdapter;
import org.kaerdan.presenterretainer.PresenterFragment;

import java.util.List;


public class ArticleListFragment
        extends PresenterFragment<ArticleListContract.Presenter, ArticleListContract.View>
        implements ArticleListContract.View {


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

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getView().findViewById(R.id.favorite_articles)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().onFavoriteArticleClick();
                    }
                });
    }

    @Override
    protected void onPresenterRestored() {
        super.onPresenterRestored();
        ArticleListContract.Presenter presenter = getPresenter();
        presenter.setNavigator(getNavigator(presenter));
    }


    @NonNull
    @Override
    protected ArticleListContract.Presenter onCreatePresenter() {
        ArticleListContract.Presenter presenter = new ArticleListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @Override
    protected ArticleListContract.View getPresenterView() {
        return this;
    }

    @NonNull
    protected ArticleListContract.Navigator getNavigator(ArticleListContract.Presenter presenter) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof ArticleListContract.NavigatorProvider) {
            return ((ArticleListContract.NavigatorProvider) parentFragment).getNavigator(presenter);
        } else {
            Activity activity = getActivity();
            if (activity instanceof ArticleListContract.NavigatorProvider) {
                return ((ArticleListContract.NavigatorProvider) activity).getNavigator(presenter);
            }
        }
        throw new IllegalStateException("Activity or parent Fragment must implement " +
                "ArticleListNavigationContract.NavigatorProvider");
    }

    @Override
    public void displayArticles(List<Article> articles, OnArticleClickListener onArticleClickListener) {
        recyclerView.setAdapter(new ArticleListAdapter(articles, onArticleClickListener));
    }
}
