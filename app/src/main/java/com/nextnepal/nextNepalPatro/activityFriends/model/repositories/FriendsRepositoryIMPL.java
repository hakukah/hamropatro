package com.nextnepal.nextNepalPatro.activityFriends.model.repositories;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;

import java.util.List;

import io.reactivex.Observable;

public class FriendsRepositoryIMPL extends BaseRepository implements FriendsRepository {
    private FriendsApiServices friendsApiServices;
    private Context context;

    public FriendsRepositoryIMPL(Context context, FriendsApiServices friendsApiServices) {
        this.context = context;
        this.friendsApiServices = friendsApiServices;
    }

    @Override
    public Observable<UsersEntity> getFriendsFromNetwork() {
        return null;
    }

    @Override
    public Observable<UsersEntity> getFriendsFromCache() {
        return null;
    }

    @Override
    public Observable<List<UsersEntity>> getFriends() {
        return null;
        //return friendsApiServices.getFriends("Bearer " + accessToken(context));
    }
}
