package com.nextnepal.nextNepalPatro.activityUsers.model.repository.add;

import android.content.Context;

import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public interface AddUsersRepository {
    Observable<BaseResponse> addUsers(Context context, String id);
}
