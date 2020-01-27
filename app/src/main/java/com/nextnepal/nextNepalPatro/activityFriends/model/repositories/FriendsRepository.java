package com.nextnepal.nextNepalPatro.activityFriends.model.repositories;

import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;

import java.util.List;

import io.reactivex.Observable;

public interface FriendsRepository {
    Observable<UsersEntity> getFriendsFromNetwork();

    Observable<UsersEntity> getFriendsFromCache();

    Observable<List<UsersEntity>> getFriends();
}
