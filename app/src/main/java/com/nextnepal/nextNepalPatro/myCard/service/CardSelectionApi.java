package com.nextnepal.nextNepalPatro.myCard.service;

import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CardSelectionApi {

    @GET("/api/cards")
    Observable<List<CardSelectionEntity>> getCard(@Header("Authorization") String auth);
}
