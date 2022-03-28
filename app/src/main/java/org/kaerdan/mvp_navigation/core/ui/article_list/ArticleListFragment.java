package org.kaerdan.mvp_navigation.core.ui.article_list;

import java.util.List;

import org.kaerdan.mvp_navigation.R;
import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.ui.ArticleListAdapter;
import org.kaerdan.mvp_navigation.core.ui.OnArticleClickListener;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ArticleListFragment extends Fragment implements ArticleListContract.View {

    private ArticleListContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    public ArticleListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
            final Bundle savedInstanceState) {
        mPresenter = createPresenter();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_article_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.article_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL,
                false));

        view.findViewById(R.id.favorite_articles).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    mPresenter.onFavoriteArticleClick();
                }
            });

        return view;
    }

    @NonNull
    protected ArticleListContract.Presenter createPresenter() {
        ArticleListContract.Presenter presenter = new ArticleListPresenter();
        presenter.setNavigator(getNavigator(presenter));
        return presenter;
    }

    @NonNull
    public ArticleListContract.Navigator getNavigator(final ArticleListContract.Presenter presenter) {
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
                + "ArticleListContract.NavigatorProvider");
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
