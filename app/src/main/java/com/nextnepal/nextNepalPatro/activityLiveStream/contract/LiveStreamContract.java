package com.nextnepal.nextNepalPatro.activityLiveStream.contract;

import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamDataDto;
import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface LiveStreamContract {
    interface View extends BaseView {
        void loadData(List<LiveStreamDataDto> liveStreamDataDtoList);
    }

    interface Presenter extends BasePresenter {
        void setView(LiveStreamContract.View view);
    }

    interface Model {
        Observable<LiveStreamEntity> getLiveStream();
    }
}
