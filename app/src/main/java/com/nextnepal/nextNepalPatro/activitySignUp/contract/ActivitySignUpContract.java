package com.nextnepal.nextNepalPatro.activitySignUp.contract;

import com.nextnepal.nextNepalPatro.activitySignUp.model.dto.SignUpResponseEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import io.reactivex.Observable;

public interface ActivitySignUpContract {
    interface View extends BaseView {
        void validate();

        void initView();

        void transferActivity();
    }

    interface Presenter extends BasePresenter {
        void setView(ActivitySignUpContract.View view);

        void saveUsers(String firstName,
                       String lastName,
                       String username,
                       String phone,
                       String email,
                       String password,
                       String confirmPassword
        );
    }

    interface Model {
        Observable<SignUpResponseEntity> saveUsers(String firstName,
                                                   String lastName,
                                                   String username,
                                                   String phone,
                                                   String email,
                                                   String password,
                                                   String confirmPassword
        );
    }
}
