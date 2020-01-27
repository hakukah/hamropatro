package com.nextnepal.nextNepalPatro.activityCardDetails.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityCardDetails.contract.UserInfoContract;
import com.nextnepal.nextNepalPatro.activityCardDetails.model.UserInfoModel;
import com.nextnepal.nextNepalPatro.activityCardDetails.model.repositories.UserInfoRepositories;
import com.nextnepal.nextNepalPatro.activityCardDetails.model.repositories.UserInfoRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityCardDetails.presenter.UserInfoPresenter;
import com.nextnepal.nextNepalPatro.activityCardDetails.services.UserInfoApiServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserInfoModule {

    @Provides
    public UserInfoContract.Model providesModel(UserInfoRepositories userInfoRepositories) {
        return new UserInfoModel(userInfoRepositories);
    }

    @Provides
    public UserInfoContract.Presenter providesPresenter(UserInfoContract.Model model, Context context) {
        return new UserInfoPresenter(model, context);
    }

    @Singleton
    @Provides
    public UserInfoRepositories providesRepo(Context context, UserInfoApiServices userInfoApiServices) {
        return new UserInfoRepositoryIMPL(context, userInfoApiServices);
    }
}
