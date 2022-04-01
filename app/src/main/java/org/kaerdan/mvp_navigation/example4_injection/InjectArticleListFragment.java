package org.kaerdan.mvp_navigation.example4_injection;

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

public class InjectArticleListFragment extends Fragment implements InjectArticleListContract.View {

    // @Inject
    InjectArticleListContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    public InjectArticleListFragment() {
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

        Injector.inject(this);

        view.findViewById(R.id.favorite_articles).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    mPresenter.onFavoriteArticleClick();
                }
            });

        return view;
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
