package org.kaerdan.mvp_navigation.core.fragments.favorite_list;

import org.kaerdan.mvp_navigation.core.data.Article;
import org.kaerdan.mvp_navigation.core.fragments.article_list.OnArticleClickListener;
import org.kaerdan.mvp_navigation.core.fragments.article_list.ArticleListNavigationContract;

import java.util.List;

public interface FavoriteArticleListContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> {
        void setNavigator(FavoriteArticleListNavigationContract.Navigator navigator);
    }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayArticles(List<Article> articles, OnArticleClickListener onArticleClickListener);
    }
}
