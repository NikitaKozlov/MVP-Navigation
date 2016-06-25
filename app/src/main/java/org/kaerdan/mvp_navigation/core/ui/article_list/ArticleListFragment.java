package org.kaerdan.mvp_navigation.core.ui.article_list;

import java.util.List;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.ui.ArticleListAdapter;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import android.app.Activity;

import android.os.Bundle;

import android.support.annotation.NonNull;

import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArticleListFragment extends Fragment implements ArticleListContract.View {

    private ArticleListContract.Presenter presenter;

    private RecyclerView recyclerView;

    public ArticleListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {
        presenter = getPresenter();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.article_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL,
                false));

        view.findViewById(R.id.favorite_articles).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    presenter.onFavoriteArticleClick();
                }
            });

        return view;
    }

    @NonNull
    protected ArticleListContract.Presenter getPresenter() {
        ArticleListContract.Presenter presenter = new ArticleListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @NonNull
    protected ArticleListContract.Navigator getNavigator(final ArticleListContract.Presenter presenter) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof ArticleListContract.NavigatorProvider) {
            return ((ArticleListContract.NavigatorProvider) parentFragment).getNavigator(presenter);
        } else {
            Activity activity = getActivity();
            if (activity instanceof ArticleListContract.NavigatorProvider) {
                return ((ArticleListContract.NavigatorProvider) activity).getNavigator(presenter);
            }
        }

        throw new IllegalStateException("Activity or parent Fragment must implement "
                + "ArticleListNavigationContract.NavigatorProvider");
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
    public void displayArticles(final List<Article> articles, final OnArticleClickListener onArticleClickListener) {
        recyclerView.setAdapter(new ArticleListAdapter(articles, onArticleClickListener));
    }
}
