package com.nextnepal.nextNepalPatro.activityRashifal.services;

import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RashifalApiService {

    @GET("admin/show-horo-daily")
    Observable<RashifalEntity> getRashifalDaily();

    @GET("admin/show-horo-weekly")
    Observable<RashifalEntity> getRashifalWeekly();

    @GET("admin/show-horo-monthly")
    Observable<RashifalEntity> getRashifalMonthly();

    @GET("admin/show-horo-yearly")
    Observable<RashifalEntity> getRashifalYearly();


}
