package com.nextnepal.nextNepalPatro.activityNews.contract;

import com.nextnepal.nextNepalPatro.activityNews.model.dto.DataEntity;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsDto;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.Data;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.NewsEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface NewsContract {

    interface View extends BaseView {

        void updateData(List<Data> newsDtoList);

    }

    interface Presenter extends BasePresenter {

        void setView(NewsContract.View view);

        void handleApiError(Throwable error);
    }

    interface Model {
        Observable<NewsEntity> getNews();
    }
}
