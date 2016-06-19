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

public class FavoriteListFragment extends PresenterFragment<FavoriteListContract.Presenter, FavoriteListContract.View>
        implements FavoriteListContract.View {

    private RecyclerView recyclerView;

    public FavoriteListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_favorite_article_list, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL,
                false));
        return recyclerView;
    }

    @Override
    protected void onPresenterRestored() {
        super.onPresenterRestored();
        FavoriteListContract.Presenter presenter = getPresenter();
        presenter.setNavigator(getNavigator(presenter));
    }

    @NonNull
    protected FavoriteListContract.Presenter onCreatePresenter() {
        FavoriteListContract.Presenter presenter = new FavoriteListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @Override
    protected FavoriteListContract.View getPresenterView() {
        return this;
    }

    @NonNull
    protected FavoriteListContract.Navigator getNavigator(
            final FavoriteListContract.Presenter presenter) {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && parentFragment instanceof FavoriteListContract.NavigatorProvider) {
            return ((FavoriteListContract.NavigatorProvider) parentFragment).getNavigator(presenter);
        } else {
            Activity activity = getActivity();
            if (activity instanceof FavoriteListContract.NavigatorProvider) {
                return ((FavoriteListContract.NavigatorProvider) activity).getNavigator(presenter);
            }
        }

        throw new IllegalStateException("Activity or parent Fragment must implement "
                + "FavoriteArticleListNavigationContract.NavigatorProvider");
    }

    @Override
    public void displayArticles(final List<Article> articles, final OnArticleClickListener onArticleClickListener) {
        recyclerView.setAdapter(new ArticleListAdapter(articles, onArticleClickListener));
    }
}
