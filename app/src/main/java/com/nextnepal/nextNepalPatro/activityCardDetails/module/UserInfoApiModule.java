package com.nextnepal.nextNepalPatro.activityCardDetails.module;

import com.nextnepal.nextNepalPatro.activityCardDetails.services.UserInfoApiServices;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class UserInfoApiModule extends BaseApiModule {
    @Provides
    public UserInfoApiServices provideForexApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(UserInfoApiServices.class);
    }
}
