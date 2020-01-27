package com.nextnepal.nextNepalPatro.activityMain.module;

import com.nextnepal.nextNepalPatro.activityMain.contract.MainActivityContract;
import com.nextnepal.nextNepalPatro.activityMain.model.MainActivityModel;
import com.nextnepal.nextNepalPatro.activityMain.presenter.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    @Singleton
    public MainActivityContract.Model provideMainActivityContractModel() {
        return new MainActivityModel();
    }

    @Provides
    @Singleton
    public MainActivityContract.Presenter providesMainActivityPresenter(MainActivityContract.Model model) {
        return new MainActivityPresenter(model);
    }
}
