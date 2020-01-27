package com.nextnepal.nextNepalPatro.activityLogin.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityLogin.contract.LoginActivityContract;
import com.nextnepal.nextNepalPatro.activityLogin.model.LoginActivityModel;
import com.nextnepal.nextNepalPatro.activityLogin.model.repository.LoginRepository;
import com.nextnepal.nextNepalPatro.activityLogin.model.repository.LoginRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityLogin.presenter.LoginActivityPresenter;
import com.nextnepal.nextNepalPatro.activityLogin.serivces.LoginApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginActivityContract.Model providesModel(LoginRepository loginRepository) {
        return new LoginActivityModel(loginRepository);
    }

    @Provides
    public LoginActivityContract.Presenter providesPresenter(LoginActivityContract.Model model, Context context) {
        return new LoginActivityPresenter(model, context);
    }

    @Provides
    @Singleton
    public LoginRepository providesRepo(Context context, LoginApiService loginApiService) {
        return new LoginRepositoryIMPL(context, loginApiService);
    }
}
