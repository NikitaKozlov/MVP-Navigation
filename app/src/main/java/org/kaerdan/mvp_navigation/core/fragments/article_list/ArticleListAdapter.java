package org.kaerdan.mvp_navigation.core.fragments.article_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.kaerdan.mvp_navigation.core.data.Article;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    private final List<Article> articles;
    private final OnArticleClickListener onArticleClickListener;

    public ArticleListAdapter(@NonNull List<Article> articles,
                              OnArticleClickListener onArticleClickListener) {
        this.articles = articles;
        this.onArticleClickListener = onArticleClickListener;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(new Button(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        final Article article = articles.get(position);
        ((Button) holder.itemView).setText(article.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onArticleClickListener.onArticleClick(article.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {
        public ArticleViewHolder(View itemView) {
            super(itemView);
        }
    }

}
