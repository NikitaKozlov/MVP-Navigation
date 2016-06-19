package org.kaerdan.mvp_navigation;

import org.kaerdan.mvp_navigation.example2_fragments.ArticleListActivity;
import org.kaerdan.mvp_navigation.example3_viewpager.ArticleViewPagerActivity;

import java.util.Arrays;
import java.util.List;

public class MainPresenter  implements MainContract.Presenter {

    private List<Integer> stringIdList = Arrays.asList(R.string.example1_title,
            R.string.example2_title, R.string.example3_title, R.string.example4_title);

    private List<Class<?>> activityClsList = Arrays.<Class<?>>asList(org.kaerdan.mvp_navigation.example1_activities.ArticleListActivity.class,
            ArticleListActivity.class, ArticleViewPagerActivity.class, org.kaerdan.mvp_navigation.example4_injection.ArticleListActivity.class);

    private MainContract.View view;


    public void onAttachView(MainContract.View view) {
        this.view = view;
        view.displayButtons(stringIdList);
    }

    public void onDetachView() {
        this.view = null;
    }


    @Override
    public void onButtonFromListClicked(int position) {
        view.launchActivity(activityClsList.get(position));
    }
}
