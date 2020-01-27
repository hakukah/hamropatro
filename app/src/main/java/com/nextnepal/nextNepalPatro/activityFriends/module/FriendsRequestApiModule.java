package com.nextnepal.nextNepalPatro.activityFriends.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityForex.services.ForexApiService;
import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class FriendsRequestApiModule extends BaseApiModule {
    @Provides
    public FriendsApiServices provideForexApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(FriendsApiServices.class);
    }
}
