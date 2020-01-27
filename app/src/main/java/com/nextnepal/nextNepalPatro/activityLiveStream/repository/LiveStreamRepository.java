package com.nextnepal.nextNepalPatro.activityLiveStream.repository;

import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamEntity;

import io.reactivex.Observable;

public interface LiveStreamRepository {
    Observable<LiveStreamEntity> getLiveStream();

    Observable<LiveStreamEntity> getLiveStreamFromCache();

    Observable<LiveStreamEntity> getLiveStreamFromNetwork();
}
