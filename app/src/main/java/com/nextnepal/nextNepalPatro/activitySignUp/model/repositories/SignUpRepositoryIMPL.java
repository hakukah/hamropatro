package com.nextnepal.nextNepalPatro.activitySignUp.model.repositories;

import com.nextnepal.nextNepalPatro.activitySignUp.model.dto.SignUpResponseEntity;
import com.nextnepal.nextNepalPatro.activitySignUp.service.SignUpService;

import io.reactivex.Observable;

public class SignUpRepositoryIMPL implements SignUpRepository {
    private SignUpService signUpService;

    public SignUpRepositoryIMPL(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @Override
    public Observable<SignUpResponseEntity> signUp(String firstName, String lastName, String userName, String phone, String email, String password, String confirmPassword) {
        return signUpService.signUP(firstName, lastName, userName, phone, email, password, confirmPassword);
    }
}
