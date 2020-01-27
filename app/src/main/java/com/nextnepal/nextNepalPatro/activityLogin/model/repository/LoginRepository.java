package com.nextnepal.nextNepalPatro.activityLogin.model.repository;

import com.nextnepal.nextNepalPatro.activityLogin.model.dto.LoginResponseDto;

import io.reactivex.Observable;

public interface LoginRepository {
    Observable<LoginResponseDto> login(String email, String password);

    boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken);

}
