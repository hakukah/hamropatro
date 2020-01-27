package com.nextnepal.nextNepalPatro.cardReceived.model.repository;

import com.nextnepal.nextNepalPatro.cardReceived.model.dto.CardReceivedDto;

import java.util.List;

import io.reactivex.Observable;

public interface CardsReceivedRepository {
    Observable<List<CardReceivedDto>> getCards();

    Observable<List<CardReceivedDto>> getCardsFromCache();

    Observable<List<CardReceivedDto>> getCardsFromNetwork();
}
