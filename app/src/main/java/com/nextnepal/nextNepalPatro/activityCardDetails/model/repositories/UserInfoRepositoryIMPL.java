package com.nextnepal.nextNepalPatro.activityCardDetails.model.repositories;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityCardDetails.model.dto.UserInfoEntity;
import com.nextnepal.nextNepalPatro.activityCardDetails.services.UserInfoApiServices;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public class UserInfoRepositoryIMPL extends BaseRepository implements UserInfoRepositories {

    private UserInfoApiServices userInfoApiServices;
    private Context context;

    public UserInfoRepositoryIMPL(Context context, UserInfoApiServices userInfoApiServices) {
        this.userInfoApiServices = userInfoApiServices;
        this.context = context;
    }

    @Override
    public Observable<BaseResponse> addDetails(UserInfoEntity usersEntity) {
        return userInfoApiServices.getUserInfoService("Bearer " + accessToken(context),
                "" + usersEntity.getDesignation(),
                "" + usersEntity.getCompany(),
                "" + usersEntity.getFacebook(),
                "" + usersEntity.getTwitter(),
                "" + usersEntity.getLinkedin()
        );
    }
}
