package com.nextnepal.nextNepalPatro.activityCardDetails.services;


import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserInfoApiServices {

    @POST("/api/add-user-info")
    @FormUrlEncoded
    Observable<BaseResponse> getUserInfoService(@Header("Authorization") String auth,
                                                @Field("designation") String designation,
                                                @Field("company") String company,
                                                @Field("facebook") String facebook,
                                                @Field("twitter") String twitter,
                                                @Field("linkedin") String linkedin);

}
