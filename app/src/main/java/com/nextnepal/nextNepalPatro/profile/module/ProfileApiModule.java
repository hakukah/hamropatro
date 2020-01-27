package com.nextnepal.nextNepalPatro.profile.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;
import com.nextnepal.nextNepalPatro.profile.service.ProfileApiService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileApiModule extends BaseApiModule {
    @Provides
    public ProfileApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(ProfileApiService.class);
    }
}
