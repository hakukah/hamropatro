package com.nextnepal.nextNepalPatro.activityMain.presenter;

import android.content.Context;
import android.view.View;

import com.nextnepal.nextNepalPatro.activityMain.contract.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.Model model;
    private MainActivityContract.View view;


    public MainActivityPresenter(MainActivityContract.Model model) {
        this.model = model;
    }

    @Override
    public void checkLogged(Context context) {
        view.checkLogged(model.checkLogged(context));
    }


    @Override
    public void setView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public boolean checkIfLogged(Context context) {
        return model.checkLogged(context);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsubscribe() {

    }
}
