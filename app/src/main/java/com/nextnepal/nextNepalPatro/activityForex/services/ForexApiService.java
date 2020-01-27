package com.nextnepal.nextNepalPatro.activityForex.services;

import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ForexApiService {
    @GET("admin/forex")
    Observable<List<ForexEntity>> getForex();
}
