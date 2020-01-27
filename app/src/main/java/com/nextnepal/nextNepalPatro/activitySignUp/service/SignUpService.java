package com.nextnepal.nextNepalPatro.activitySignUp.service;

import com.nextnepal.nextNepalPatro.activitySignUp.model.dto.SignUpResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SignUpService {

    @FormUrlEncoded
    @POST("register")
    Observable<SignUpResponseEntity> signUP(@Field("first_name") String firstName,
                                            @Field("last_name") String lastName,
                                            @Field("username") String username,
                                            @Field("email") String email,
                                            @Field("phone") String phone,
                                            @Field("password") String password,
                                            @Field("confirm_password") String confirmPassword
    );
}
