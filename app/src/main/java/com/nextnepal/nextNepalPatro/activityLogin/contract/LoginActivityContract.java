package com.nextnepal.nextNepalPatro.activityLogin.contract;

import com.nextnepal.nextNepalPatro.activityLogin.model.dto.LoginResponseDto;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import io.reactivex.Observable;

public interface LoginActivityContract {
    interface View extends BaseView {

        void transferActivity();

    }

    interface Model {
        Observable<LoginResponseDto> login(String email, String password);

        boolean saveToken(String tokenType, int expiresIn, String accessToken, String refreshToken);

    }

    interface Presenter extends BasePresenter {
        void setView(LoginActivityContract.View view);

        void login(String email, String password);
    }
}
