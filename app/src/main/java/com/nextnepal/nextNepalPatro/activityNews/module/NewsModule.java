package com.nextnepal.nextNepalPatro.activityNews.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityNews.contract.NewsContract;
import com.nextnepal.nextNepalPatro.activityNews.model.NewsModel;
import com.nextnepal.nextNepalPatro.activityNews.presenter.NewsPresenter;
import com.nextnepal.nextNepalPatro.activityNews.model.repository.NewsRepositories;
import com.nextnepal.nextNepalPatro.activityNews.model.repository.NewsRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityNews.services.NewsApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsModule {

    @Provides
    public NewsContract.Presenter provideNewsPresenter(NewsContract.Model model,Context context) {
        return new NewsPresenter(model,context);
    }

    @Provides
    public NewsContract.Model provideNewsModel(NewsRepositories newsRepositories) {
        return new NewsModel(newsRepositories);
    }

    @Singleton
    @Provides
    public NewsRepositories provideNewsRepo(Context context, NewsApiService newsApiService) {
        return new NewsRepositoryIMPL(newsApiService, context);
    }

}
