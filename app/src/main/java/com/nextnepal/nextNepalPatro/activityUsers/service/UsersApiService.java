package com.nextnepal.nextNepalPatro.activityUsers.service;

import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface UsersApiService {
    @GET("users")
    Observable<List<UsersEntity>> getUsersList(@Header("Authorization") String Auth);

    @GET("add-friend/{id}")
    Call<BaseResponse> sentFriendRequest(@Header("Authorization") String Auth,
                                         @Path("id") String id);
}
