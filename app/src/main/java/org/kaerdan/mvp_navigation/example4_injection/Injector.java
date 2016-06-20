package org.kaerdan.mvp_navigation.example4_injection;

public class Injector {

    static void inject(final ArticleListFragment fragment) {
        ArticleListPresenter presenter = new ArticleListPresenter();
        presenter.navigator = new ActivityNavigator(fragment.getContext());
        fragment.presenter = presenter;
    }
}
