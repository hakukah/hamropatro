package com.nextnepal.nextNepalPatro.activityFriends.model.repositories;

import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendsListEntity;

import java.util.List;

import io.reactivex.Observable;

public interface FriendsListRepository {
    Observable<FriendsListEntity> getFriendsFromCache();

    Observable<FriendsListEntity> getFriendsFromNetwork();

    Observable<FriendsListEntity> getFriends();
}
