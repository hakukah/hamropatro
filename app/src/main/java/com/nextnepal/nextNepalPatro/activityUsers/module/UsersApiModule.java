package com.nextnepal.nextNepalPatro.activityUsers.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersApiModule extends BaseApiModule {
    @Provides
    public UsersApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(UsersApiService.class);
    }
}
