package com.nextnepal.nextNepalPatro.activityLiveStream.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityLiveStream.contract.LiveStreamContract;
import com.nextnepal.nextNepalPatro.activityLiveStream.model.LiveStreamModel;
import com.nextnepal.nextNepalPatro.activityLiveStream.presenter.LiveStreamPresenter;
import com.nextnepal.nextNepalPatro.activityLiveStream.repository.LiveStreamRepository;
import com.nextnepal.nextNepalPatro.activityLiveStream.repository.LiveStreamRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityLiveStream.service.LiveStreamApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LiveStreamModule {

    @Provides
    public LiveStreamContract.Model provideModel(LiveStreamRepository liveStreamRepository) {
        return new LiveStreamModel(liveStreamRepository);
    }

    @Provides
    public LiveStreamContract.Presenter providePresenter(LiveStreamContract.Model liveStreamModel, Context context) {
        return new LiveStreamPresenter(liveStreamModel, context);
    }

    @Provides
    @Singleton
    public LiveStreamRepository providesRepos(LiveStreamApiService liveStreamApiService) {
        return new LiveStreamRepositoryIMPL(liveStreamApiService);
    }
}
