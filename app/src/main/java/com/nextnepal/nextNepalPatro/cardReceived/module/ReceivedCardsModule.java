package com.nextnepal.nextNepalPatro.cardReceived.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.cardReceived.contract.CardsReceivedContract;
import com.nextnepal.nextNepalPatro.cardReceived.model.CardReceivedModel;
import com.nextnepal.nextNepalPatro.cardReceived.model.repository.CardsReceivedRepository;
import com.nextnepal.nextNepalPatro.cardReceived.model.repository.CardsReceivedRepositoryIMPL;
import com.nextnepal.nextNepalPatro.cardReceived.presenter.CardsPresenter;
import com.nextnepal.nextNepalPatro.cardReceived.service.CardsApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class ReceivedCardsModule {
    @Provides
    public CardsReceivedContract.Model providesModel(CardsReceivedRepository cardsReceivedRepository) {
        return new CardReceivedModel(cardsReceivedRepository);
    }

    @Provides
    public CardsReceivedContract.Presenter providesPresenter(CardsReceivedContract.Model model) {
        return new CardsPresenter(model);
    }

    @Provides
    public CardsReceivedRepository providesRepository(Context context, CardsApiService cardsApiService) {
        return new CardsReceivedRepositoryIMPL(context, cardsApiService);
    }
}
