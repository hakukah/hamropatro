package com.nextnepal.nextNepalPatro.activityLogin.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.nextnepal.nextNepalPatro.activityLogin.model.dto.LoginResponseDto;
import com.nextnepal.nextNepalPatro.activityLogin.serivces.LoginApiService;

import io.reactivex.Observable;

public class LoginRepositoryIMPL implements LoginRepository {
    private LoginApiService loginApiService;
    private Context context_dco;

    public LoginRepositoryIMPL(Context context_dco, LoginApiService loginApiService) {
        this.context_dco = context_dco;
        this.loginApiService = loginApiService;
    }

    @Override
    public Observable<LoginResponseDto> login(String email, String password) {
        return loginApiService.login(email, password);
    }


    @Override
    public boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken) {
        try {
            SharedPreferences sharedPreferences = context_dco.getSharedPreferences("Token", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("tokenType", tokenType);
            editor.putInt("expiresIn", expiresIn);
            editor.putString("accessToken", accessToken);
            editor.putString("refreshToken", refreshToken);
            editor.putBoolean("loggedIn", true);
            editor.commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
