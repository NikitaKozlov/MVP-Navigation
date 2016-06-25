package org.kaerdan.mvp_navigation;

import android.support.annotation.NonNull;

import java.util.List;

public interface MainContract {
    interface Presenter extends org.kaerdan.mvp_navigation.core.Presenter<View> {
        void onButtonFromListClicked(int position);
    }

    interface View extends org.kaerdan.mvp_navigation.core.Presenter.View {
        void displayButtons(@NonNull List<Integer> stringIdList);
        void launchActivity(@NonNull Class<?> cls);
    }
}
