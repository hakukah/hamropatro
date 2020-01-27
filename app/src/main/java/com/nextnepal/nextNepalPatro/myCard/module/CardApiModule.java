package com.nextnepal.nextNepalPatro.myCard.module;

import com.nextnepal.nextNepalPatro.myCard.service.CardSelectionApi;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import dagger.Module;
import dagger.Provides;

@Module
public class CardApiModule extends BaseApiModule {
    @Provides
    public CardSelectionApi provideCardApiService() {

        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(CardSelectionApi.class);
    }
}
