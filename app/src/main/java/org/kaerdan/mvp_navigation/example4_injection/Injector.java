package org.kaerdan.mvp_navigation.example4_injection;

public class Injector {

    static void inject(final InjectArticleListFragment fragment) {
        InjectArticleListPresenter presenter = new InjectArticleListPresenter();
        presenter.mNavigator = new InjectActivityNavigator(fragment.getContext());
        fragment.mPresenter = presenter;
    }
}
