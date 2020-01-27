package com.nextnepal.nextNepalPatro.activityNews.contract;

import com.nextnepal.nextNepalPatro.activityNews.model.dto.BBC.BBCDto;

import java.util.List;

import io.reactivex.Observable;

public interface BBCContract {

    interface View {
        void initView();

        void showMessage(String message);

        void loadBBcNews(List<BBCDto> bbcDtoList);
    }

    interface Model {
        Observable<BBCDto> getBBCNews();
    }

    interface Presenter {
        void setView(BBCContract.View view);

        void loadData();

        void rxUnsuscribe();
    }
}
