package com.nextnepal.nextNepalPatro.cardReceived.service;

import com.nextnepal.nextNepalPatro.cardReceived.model.dto.CardReceivedDto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CardsApiService {

    @GET("view-shared-card")
    Observable<List<CardReceivedDto>> getCards(@Header("Authorization") String auth);
}
