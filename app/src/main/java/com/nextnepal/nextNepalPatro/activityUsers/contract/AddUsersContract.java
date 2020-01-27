package com.nextnepal.nextNepalPatro.activityUsers.contract;

import android.content.Context;

import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public interface AddUsersContract {
    interface Model {
        Observable<BaseResponse> addFriend(Context context, String id);
    }

    interface Presenter {
        Observable<BaseResponse> addFriend(Context context, String id);
    }
}
