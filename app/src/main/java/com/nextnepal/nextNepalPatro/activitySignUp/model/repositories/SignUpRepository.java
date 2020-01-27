package com.nextnepal.nextNepalPatro.activitySignUp.model.repositories;

import com.nextnepal.nextNepalPatro.activitySignUp.model.dto.SignUpResponseEntity;

import io.reactivex.Observable;

public interface SignUpRepository {
    Observable<SignUpResponseEntity> signUp(String firstName, String lastName, String userName, String phone, String email, String password,String confirmPassword);
}
