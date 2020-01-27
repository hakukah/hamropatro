package com.nextnepal.nextNepalPatro.activitySignUp.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activitySignUp.contract.ActivitySignUpContract;
import com.nextnepal.nextNepalPatro.activitySignUp.model.ActivitySignUpModel;
import com.nextnepal.nextNepalPatro.activitySignUp.presenter.ActivitySignUpPresenter;
import com.nextnepal.nextNepalPatro.activitySignUp.model.repositories.SignUpRepository;
import com.nextnepal.nextNepalPatro.activitySignUp.model.repositories.SignUpRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activitySignUp.service.SignUpService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SignUpModule {

    @Provides
    public ActivitySignUpContract.Presenter providesPresenter(ActivitySignUpContract.Model model, Context context) {
        return new ActivitySignUpPresenter(model, context);
    }

    @Provides
    public ActivitySignUpContract.Model providesModel(SignUpRepository signUpRepository) {
        return new ActivitySignUpModel(signUpRepository);
    }

    @Provides
    @Singleton
    public SignUpRepository provideRepo(SignUpService signUpService) {
        return new SignUpRepositoryIMPL(signUpService);
    }
}
