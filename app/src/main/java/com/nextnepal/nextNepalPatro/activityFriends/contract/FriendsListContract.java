package com.nextnepal.nextNepalPatro.activityFriends.contract;

import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendListDataDto;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendsListEntity;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface FriendsListContract {
    interface View extends BaseView {
        void loadFriends(List<FriendListDataDto> usersEntityList);
    }

    interface Presenter extends BasePresenter {
        void setView(FriendsListContract.View view);
    }

    interface Model {
        Observable<FriendsListEntity> getFriends();
    }
}
