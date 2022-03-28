package org.kaerdan.mvp_navigation.core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.kaerdan.mvp_navigation.core.data.Article;
import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    private final List<Article> mArticles;
    private final OnArticleClickListener mOnArticleClickListener;

    public ArticleListAdapter(@NonNull final List<Article> articles,
                              @NonNull final OnArticleClickListener onArticleClickListener) {
        this.mArticles = articles;
        this.mOnArticleClickListener = onArticleClickListener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ArticleViewHolder(new Button(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder holder, final int position) {
        final Article article = mArticles.get(position);
        ((Button) holder.itemView).setText(article.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mOnArticleClickListener.onArticleClick(article.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        public ArticleViewHolder(final View itemView) {
            super(itemView);
        }
    }
}
