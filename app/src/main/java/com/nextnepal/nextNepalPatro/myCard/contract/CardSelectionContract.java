package com.nextnepal.nextNepalPatro.myCard.contract;

import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface CardSelectionContract {

    interface View extends BaseView {
        void initView();

        void loadCard(List<CardSelectionEntity> cardSelectionEntityArrayList);
    }

    interface Presenter extends BasePresenter {
        void setView(CardSelectionContract.View view);
    }

    interface Model {
        Observable<List<CardSelectionEntity>> getCard();
    }
}
