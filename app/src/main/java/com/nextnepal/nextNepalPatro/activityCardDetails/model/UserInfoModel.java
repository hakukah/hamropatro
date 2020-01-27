package com.nextnepal.nextNepalPatro.activityCardDetails.model;

import com.nextnepal.nextNepalPatro.activityCardDetails.contract.UserInfoContract;
import com.nextnepal.nextNepalPatro.activityCardDetails.model.dto.UserInfoEntity;
import com.nextnepal.nextNepalPatro.activityCardDetails.model.repositories.UserInfoRepositories;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public class UserInfoModel implements UserInfoContract.Model {

    private UserInfoRepositories userInfoRepositories;

    public UserInfoModel(UserInfoRepositories userInfoRepositories) {
        this.userInfoRepositories = userInfoRepositories;
    }

    @Override
    public Observable<BaseResponse> addDetails(UserInfoEntity userInfoEntity) {
        return userInfoRepositories.addDetails(userInfoEntity);
    }
}
