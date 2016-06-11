package org.kaerdan.mvp_navigation.core;

public interface Presenter<T extends Presenter.View> {

    /**
     * Called to attach view to the Presenter
     * @param view view to attach
     */
    void onAttachView(T view);

    /**
     * Called to detach view from the Presenter
     */
    void onDetachView();

    /**
     * Interface represents View in MVP approach.
     */
    interface View {

    }
}
