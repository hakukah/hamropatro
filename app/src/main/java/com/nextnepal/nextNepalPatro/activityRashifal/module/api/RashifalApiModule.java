package com.nextnepal.nextNepalPatro.activityRashifal.module.api;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;
import com.nextnepal.nextNepalPatro.util.mvp.BaseApiModule;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RashifalApiModule extends BaseApiModule {

    @Provides
    public RashifalApiService provideRashifalApiService() {
        return provideRetrofit(RestURL.BASE_URL, provideOkHttp()).create(RashifalApiService.class);
    }
}
