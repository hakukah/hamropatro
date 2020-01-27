package com.nextnepal.nextNepalPatro.activitySignUp.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activitySignUp.service.SignUpService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpApiModule extends BaseApiModule {
    @Provides
    public SignUpService provideApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(SignUpService.class);
    }
}
