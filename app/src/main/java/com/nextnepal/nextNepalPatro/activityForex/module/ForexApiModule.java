package com.nextnepal.nextNepalPatro.activityForex.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityForex.services.ForexApiService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class ForexApiModule extends BaseApiModule {
    @Provides
    public ForexApiService provideForexApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(ForexApiService.class);
    }

}
