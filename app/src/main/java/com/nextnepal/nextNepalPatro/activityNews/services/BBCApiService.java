package com.nextnepal.nextNepalPatro.activityNews.services;

import com.nextnepal.nextNepalPatro.activityNews.model.dto.BBC.BBCDto;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BBCApiService {

    @GET("top-headlines")
    Observable<BBCDto> getBBC(
            @Query("sources") String sources,
            @Query("apiKey") String apiKey);

}
