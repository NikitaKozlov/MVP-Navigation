package org.kaerdan.mvp_navigation.core.fragments;

import java.util.List;

import org.kaerdan.mvp_navigation.core.data.Article;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    private final List<Article> articles;
    private final OnArticleClickListener onArticleClickListener;

    public ArticleListAdapter(@NonNull final List<Article> articles,
            @NonNull final OnArticleClickListener onArticleClickListener) {
        this.articles = articles;
        this.onArticleClickListener = onArticleClickListener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ArticleViewHolder(new Button(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder holder, final int position) {
        final Article article = articles.get(position);
        ((Button) holder.itemView).setText(article.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    onArticleClickListener.onArticleClick(article.getId());
                }
            });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        public ArticleViewHolder(final View itemView) {
            super(itemView);
        }
    }

}
