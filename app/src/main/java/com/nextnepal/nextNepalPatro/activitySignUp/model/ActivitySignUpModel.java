package com.nextnepal.nextNepalPatro.activitySignUp.model;

import com.nextnepal.nextNepalPatro.activitySignUp.contract.ActivitySignUpContract;
import com.nextnepal.nextNepalPatro.activitySignUp.model.dto.SignUpResponseEntity;
import com.nextnepal.nextNepalPatro.activitySignUp.model.repositories.SignUpRepository;

import io.reactivex.Observable;

public class ActivitySignUpModel implements ActivitySignUpContract.Model {
    private SignUpRepository signUpRepository;

    public ActivitySignUpModel(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @Override
    public Observable<SignUpResponseEntity> saveUsers(String firstName, String lastName, String username, String phone, String email, String password, String confirmPassword) {
        return signUpRepository.signUp(firstName, lastName, username, phone, email, password, confirmPassword);
    }
}
