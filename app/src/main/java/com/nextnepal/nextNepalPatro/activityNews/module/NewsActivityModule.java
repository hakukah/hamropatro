package com.nextnepal.nextNepalPatro.activityNews.module;

import com.nextnepal.nextNepalPatro.activityNews.contract.NewsPortalActivityContract;
import com.nextnepal.nextNepalPatro.activityNews.model.NewsActivityModel;
import com.nextnepal.nextNepalPatro.activityNews.presenter.NewsActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsActivityModule {


    @Provides
    @Singleton
    public NewsPortalActivityContract.Model provideNewsActivityContractModel() {
        return new NewsActivityModel();
    }

    @Provides
    @Singleton
    public NewsPortalActivityContract.Presenter providesMainActivityPresenter(NewsPortalActivityContract.Model model) {
        return new NewsActivityPresenter(model);

    }
}
