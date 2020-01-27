package com.nextnepal.nextNepalPatro.activityFriends.contract;

import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface FriendsRequestContract {
    interface View extends BaseView {
        void loadFriends(List<UsersEntity> usersEntityList);
    }

    interface Presenter extends BasePresenter {
        void setView(FriendsRequestContract.View view);
    }

    interface Model {
        Observable<List<UsersEntity>> getFriends();
    }
}
