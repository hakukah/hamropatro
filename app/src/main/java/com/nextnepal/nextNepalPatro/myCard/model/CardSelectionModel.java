package com.nextnepal.nextNepalPatro.myCard.model;

import com.nextnepal.nextNepalPatro.myCard.contract.CardSelectionContract;
import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;

import java.util.List;

import io.reactivex.Observable;

public class CardSelectionModel implements CardSelectionContract.Model {

    private CardRepository cardRepository;

    public CardSelectionModel(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Observable<List<CardSelectionEntity>> getCard() {
        return cardRepository.getCard();
    }
}
