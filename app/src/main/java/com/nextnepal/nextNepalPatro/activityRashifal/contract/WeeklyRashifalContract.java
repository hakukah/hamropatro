package com.nextnepal.nextNepalPatro.activityRashifal.contract;

import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalDto;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface WeeklyRashifalContract {
    interface View extends BaseView {

        void updateData(List<RashifalDto> rashifalDtoList);

        void setDate(String date);
    }

    interface Presenter extends BasePresenter {

        void setView(WeeklyRashifalContract.View view);

    }

    interface Model {
        Observable<RashifalEntity> getWeeklyRashifal();

    }
}
