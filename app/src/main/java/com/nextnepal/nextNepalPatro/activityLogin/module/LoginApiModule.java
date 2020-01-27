package com.nextnepal.nextNepalPatro.activityLogin.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityLogin.serivces.LoginApiService;
import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginApiModule extends BaseApiModule {
    @Provides
    public LoginApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(LoginApiService.class);
    }
}
