package com.nextnepal.nextNepalPatro.activityCardSharing.service;

import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CardSharingApiService {
    @POST("share-visiting-card")
    @FormUrlEncoded
    Call<BaseResponse> shareCard
            (@Header("Authorization") String Auth,
             @Field("friend_id") String friendId,
             @Field("visiting_card_id") String visitingCardId
            );
}
