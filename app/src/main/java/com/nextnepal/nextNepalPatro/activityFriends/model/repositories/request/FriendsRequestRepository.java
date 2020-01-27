package com.nextnepal.nextNepalPatro.activityFriends.model.repositories.request;

import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;

import java.util.List;

import io.reactivex.Observable;

public interface FriendsRequestRepository {
    Observable<UsersEntity> getFriendsFromNetwork();

    Observable<UsersEntity> getFriendsFromCache();

    Observable<List<UsersEntity>> getFriends();
}
