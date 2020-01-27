package com.nextnepal.nextNepalPatro.activityLogin.model;

import com.nextnepal.nextNepalPatro.activityLogin.contract.LoginActivityContract;
import com.nextnepal.nextNepalPatro.activityLogin.model.dto.LoginResponseDto;
import com.nextnepal.nextNepalPatro.activityLogin.model.repository.LoginRepository;

import io.reactivex.Observable;

public class LoginActivityModel implements LoginActivityContract.Model {
    private LoginRepository loginRepository;

    public LoginActivityModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Observable<LoginResponseDto> login(String email, String password) {
        return loginRepository.login(email, password);
    }

    @Override
    public boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken) {
        if (loginRepository.saveToken(tokenType, expiresIn, accessToken, refreshToken)) ;
        return true;
    }
}
