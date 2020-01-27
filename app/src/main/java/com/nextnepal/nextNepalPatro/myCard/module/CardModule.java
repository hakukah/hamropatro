package com.nextnepal.nextNepalPatro.myCard.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.myCard.contract.CardSelectionContract;
import com.nextnepal.nextNepalPatro.myCard.model.CardRepository;
import com.nextnepal.nextNepalPatro.myCard.model.CardRepositoryIMPL;
import com.nextnepal.nextNepalPatro.myCard.model.CardSelectionModel;
import com.nextnepal.nextNepalPatro.myCard.presenter.CardSelectionPresenter;
import com.nextnepal.nextNepalPatro.myCard.service.CardSelectionApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CardModule {
    @Provides
    public CardSelectionContract.Presenter providesPresenter(CardSelectionContract.Model model, Context context) {
        return new CardSelectionPresenter(model, context);
    }

    @Provides
    public CardSelectionContract.Model providesModel(CardRepository cardRepository) {
        return new CardSelectionModel(cardRepository);
    }

    @Provides
    @Singleton
    public CardRepository provideRepository(Context context, CardSelectionApi cardSelectionApi) {
        return new CardRepositoryIMPL(context, cardSelectionApi);
    }
}
