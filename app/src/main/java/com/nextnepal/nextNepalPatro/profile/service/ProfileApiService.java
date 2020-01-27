package com.nextnepal.nextNepalPatro.profile.service;

import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;

import javax.annotation.Generated;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ProfileApiService {
    @GET("user-profile")
    Observable<ProfileDto> getProfileInfo(
            @Header("Authorization") String auth
    );
}
