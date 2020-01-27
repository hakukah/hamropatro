package com.nextnepal.nextNepalPatro.activityForex.contract;

import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface ForexContract {
    interface View extends BaseView {
        void loadData(List<ForexEntity> forexEntityList);
    }

    interface Presenter extends BasePresenter {
        void setView(ForexContract.View view);
    }

    interface Model {
        Observable<List<ForexEntity>> getForex();
    }
}
