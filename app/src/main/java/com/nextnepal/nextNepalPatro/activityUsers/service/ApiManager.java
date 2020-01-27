package com.nextnepal.nextNepalPatro.activityUsers.service;

import com.nextnepal.nextNepalPatro.activityCardSharing.service.CardSharingApiService;
import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {


    private ApiManager() {
    }


    public static UsersApiService getAPIService() {

        return getClient(RestURL.BASE_URL).create(UsersApiService.class);
    }

    public static FriendsApiServices getFriendsApiService() {
        return getClient(RestURL.BASE_URL).create(FriendsApiServices.class);
    }

    public static CardSharingApiService getCardSharingApiService() {
        return getClient(RestURL.BASE_URL).create(CardSharingApiService.class);
    }


    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
