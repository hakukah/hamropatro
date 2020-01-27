package com.nextnepal.nextNepalPatro.cardReceived.contract;

import com.nextnepal.nextNepalPatro.cardReceived.model.dto.CardReceivedDto;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

import io.reactivex.Observable;

public interface CardsReceivedContract {
    interface View extends BaseView {
        void receivedCard(List<CardReceivedDto> cardReceivedDtos);
    }

    interface Presenter extends BasePresenter {
        void setView(CardsReceivedContract.View view);
    }

    interface Model {
        Observable<List<CardReceivedDto>> getCards();

    }
}
