package com.nextnepal.nextNepalPatro.activityUsers.model;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityUsers.contract.AddUsersContract;
import com.nextnepal.nextNepalPatro.activityUsers.model.repository.add.AddUsersRepository;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public class AddUsersModel implements AddUsersContract.Model {
    private AddUsersRepository addUsersRepository;
    private Context context;

    public AddUsersModel(Context context, AddUsersRepository addUsersRepository) {
        this.context = context;
        this.addUsersRepository = addUsersRepository;
    }

    @Override
    public Observable<BaseResponse> addFriend(Context context, String id) {
        return addUsersRepository.addUsers(context, id);
    }
}
