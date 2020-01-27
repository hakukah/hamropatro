package com.nextnepal.nextNepalPatro.activityLiveStream.service;

import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamEntity;

import javax.annotation.Generated;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LiveStreamApiService {

    @GET("admin/tv-videos")
    Observable<LiveStreamEntity> getLiveStream();
}
