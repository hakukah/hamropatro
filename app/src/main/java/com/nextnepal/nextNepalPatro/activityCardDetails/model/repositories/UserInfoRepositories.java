package com.nextnepal.nextNepalPatro.activityCardDetails.model.repositories;

import com.nextnepal.nextNepalPatro.activityCardDetails.model.dto.UserInfoEntity;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public interface UserInfoRepositories {
    Observable<BaseResponse> addDetails(UserInfoEntity usersEntity);
}
