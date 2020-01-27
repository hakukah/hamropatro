package com.nextnepal.nextNepalPatro.activityCardDetails.contract;

import com.nextnepal.nextNepalPatro.activityCardDetails.model.dto.UserInfoEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import io.reactivex.Observable;

public interface UserInfoContract {
    interface View extends BaseView {
        void transferActivity();
    }

    interface Presenter extends BasePresenter {
        void setView(UserInfoContract.View view);

        void addDetails(UserInfoEntity userInfoEntity);
    }

    interface Model {
        Observable<BaseResponse> addDetails(UserInfoEntity userInfoEntity);
    }
}
