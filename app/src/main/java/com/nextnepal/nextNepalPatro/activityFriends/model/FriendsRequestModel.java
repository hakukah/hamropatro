package com.nextnepal.nextNepalPatro.activityFriends.model;

import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsRequestContract;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.request.FriendsRequestRepository;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;

import java.util.List;

import io.reactivex.Observable;

public class FriendsRequestModel implements FriendsRequestContract.Model {
    private FriendsRequestRepository friendsRequestRepository;

    public FriendsRequestModel(FriendsRequestRepository friendsRequestRepository) {
        this.friendsRequestRepository = friendsRequestRepository;
    }

    @Override
    public Observable<List<UsersEntity>> getFriends() {
        return friendsRequestRepository.getFriends();
    }
}
