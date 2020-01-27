package com.nextnepal.nextNepalPatro.activityLiveStream.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityLiveStream.service.LiveStreamApiService;
import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class LiveStreamApiModule extends BaseApiModule {
    @Provides
    public LiveStreamApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(LiveStreamApiService.class);
    }
}
