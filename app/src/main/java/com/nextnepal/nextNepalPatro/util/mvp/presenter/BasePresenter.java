package com.nextnepal.nextNepalPatro.util.mvp.presenter;

import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

/**
 * This interface contains shared abstract method across contract interface
 */
public interface BasePresenter {
    void loadData();

    void rxUnsubscribe();
}
