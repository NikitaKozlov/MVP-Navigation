package org.kaerdan.mvp_navigation;

import java.util.Arrays;
import java.util.List;

import org.kaerdan.mvp_navigation.example2_fragments.FragmentsArticleListActivity;
import org.kaerdan.mvp_navigation.example3_viewpager.ViewPagerActivity;
import org.kaerdan.mvp_navigation.example4_injection.InjectArticleListActivity;
import org.kaerdan.mvp_navigation.example5_retainpresenter.RetainPresenterArticleListActivity;

public class MainPresenter implements MainContract.Presenter {

    private final List<Integer> mStringIdList = Arrays.asList(R.string.example1_title, R.string.example2_title,
            R.string.example3_title, R.string.example4_title, R.string.example5_title);

    private final List<Class<?>> mActivityClsList = Arrays.<Class<?>>asList(
            org.kaerdan.mvp_navigation.example1_activities.ArticleListActivity.class,
            FragmentsArticleListActivity.class, ViewPagerActivity.class, InjectArticleListActivity.class,
            RetainPresenterArticleListActivity.class);

    private MainContract.View mView;

    public void onAttachView(final MainContract.View view) {
        this.mView = view;
        view.displayButtons(mStringIdList);
    }

    public void onDetachView() {
        this.mView = null;
    }

    @Override
    public void onButtonFromListClicked(final int position) {
        mView.launchActivity(mActivityClsList.get(position));
    }
}
