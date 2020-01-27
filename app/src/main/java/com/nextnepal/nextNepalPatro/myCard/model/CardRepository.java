package com.nextnepal.nextNepalPatro.myCard.model;


import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;

import java.util.List;

import io.reactivex.Observable;

public interface CardRepository {
    Observable<List<CardSelectionEntity>> getCardFromCache();

    Observable<List<CardSelectionEntity>> getCardFromNetwork();

    Observable<List<CardSelectionEntity>> getCard();
}
