package com.nextnepal.nextNepalPatro.activityUsers.contract;

import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface UsersContract {
    interface View extends BaseView {
        void loadUserList(List<UsersEntity> usersEntityList);
    }

    interface Model {
        Observable<List<UsersEntity>> getUserList();
    }

    interface Presenter extends BasePresenter {
        void setView(UsersContract.View view);
    }
}
