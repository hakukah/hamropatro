package com.nextnepal.nextNepalPatro.activityFriends.model;

import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsListContract;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendsListEntity;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.FriendsListRepository;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.FriendsRepository;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;

import java.util.List;

import io.reactivex.Observable;

public class FriendsListModel implements FriendsListContract.Model {
    private FriendsListRepository friendsRepository;

    public FriendsListModel(FriendsListRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    @Override
    public Observable<FriendsListEntity> getFriends() {
        return friendsRepository.getFriends();
    }
}
