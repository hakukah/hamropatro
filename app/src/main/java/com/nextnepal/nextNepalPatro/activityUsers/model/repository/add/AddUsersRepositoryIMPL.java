package com.nextnepal.nextNepalPatro.activityUsers.model.repository.add;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public class AddUsersRepositoryIMPL extends BaseRepository implements AddUsersRepository {
    private UsersApiService usersApiService;

    public AddUsersRepositoryIMPL(UsersApiService usersApiService) {
        this.usersApiService = usersApiService;
    }

    @Override
    public Observable<BaseResponse> addUsers(Context context, String id) {
        return null;
    }

//    @Override
//    public Observable<BaseResponse> addUsers(Context context, String id) {
//        return usersApiService.sentFriendRequest(accessToken(context), id);
//    }
}
