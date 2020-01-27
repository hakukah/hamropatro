package com.nextnepal.nextNepalPatro.cardReceived.module;

import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;
import com.nextnepal.nextNepalPatro.cardReceived.service.CardsApiService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class ReceivedCardsApiModule extends BaseApiModule {
    @Provides
    public CardsApiService provideApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(CardsApiService.class);
    }
}
