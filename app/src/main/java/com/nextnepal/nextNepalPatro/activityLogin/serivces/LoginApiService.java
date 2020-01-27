package com.nextnepal.nextNepalPatro.activityLogin.serivces;

import com.nextnepal.nextNepalPatro.activityLogin.model.dto.LoginResponseDto;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApiService {
    @POST("login")
    @FormUrlEncoded
    Observable<LoginResponseDto> login(@Field("username") String username,
                                       @Field("password") String password);
}
