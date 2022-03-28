package org.kaerdan.mvp_navigation.core.ui.favorite_list;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.ui.ArticleListAdapter;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;

import java.util.List;

public class FavoriteListFragment extends Fragment implements FavoriteListContract.View {

    private FavoriteListContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    public FavoriteListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {
        mPresenter = createPresenter();

        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_favorite_article_list, container, false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL,
                false));
        return mRecyclerView;
    }

    @NonNull
    protected FavoriteListContract.Presenter createPresenter() {
        FavoriteListContract.Presenter presenter = new FavoriteListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @NonNull
    protected FavoriteListContract.Navigator getNavigator(final FavoriteListContract.Presenter presenter) {
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
                + "FavoriteListContract.NavigatorProvider");
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
    public void displayArticles(@NonNull final List<Article> articles,
            @NonNull final OnArticleClickListener onArticleClickListener) {
        mRecyclerView.setAdapter(new ArticleListAdapter(articles, onArticleClickListener));
    }
}
