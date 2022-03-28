package org.kaerdan.mvp_navigation;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;

public class MainNavigator implements MainContract.Navigator {

    private final Context mActivityContext;

    public MainNavigator(Context activityContext) {
        this.mActivityContext = activityContext;
    }

    @Override
    public void launchActivity(@NonNull final Class<?> cls) {
        mActivityContext.startActivity(new Intent(mActivityContext, cls));
    }
}
