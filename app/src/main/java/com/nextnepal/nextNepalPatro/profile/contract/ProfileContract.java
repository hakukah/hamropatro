package com.nextnepal.nextNepalPatro.profile.contract;

import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import io.reactivex.Observable;

public interface ProfileContract {
    interface View extends BaseView {
        void loadProfileDetail(ProfileDto profileDto);

    }

    interface Presenter extends BasePresenter {
        void setView(ProfileContract.View view);

    }

    interface Model {
        Observable<ProfileDto> getProfileInfo();
    }
}
