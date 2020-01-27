package com.nextnepal.nextNepalPatro.cardReceived.model;

import com.nextnepal.nextNepalPatro.cardReceived.contract.CardsReceivedContract;
import com.nextnepal.nextNepalPatro.cardReceived.model.dto.CardReceivedDto;
import com.nextnepal.nextNepalPatro.cardReceived.model.repository.CardsReceivedRepository;

import java.util.List;

import io.reactivex.Observable;

public class CardReceivedModel implements CardsReceivedContract.Model {
    private CardsReceivedRepository cardsReceivedRepository;

    public CardReceivedModel(CardsReceivedRepository cardsReceivedRepository) {
        this.cardsReceivedRepository = cardsReceivedRepository;
    }

    @Override
    public Observable<List<CardReceivedDto>> getCards() {
        return cardsReceivedRepository.getCards();
    }
}
