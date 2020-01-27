package com.nextnepal.nextNepalPatro.util.mvp.view;

/**
 * This interface contains shared abstract method across contract interface
 */
public interface BaseView {
    void initView();

    void displayMessage(String message);

    void showLoading(boolean isLoading);

    void onError(String message);

    void onSucess();

}
