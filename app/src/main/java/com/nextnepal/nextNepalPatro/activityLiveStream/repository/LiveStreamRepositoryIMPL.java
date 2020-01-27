package com.nextnepal.nextNepalPatro.activityLiveStream.repository;

import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamEntity;
import com.nextnepal.nextNepalPatro.activityLiveStream.service.LiveStreamApiService;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import io.reactivex.Observable;

public class LiveStreamRepositoryIMPL implements LiveStreamRepository {

    private LiveStreamApiService liveStreamApiService;
    private long timeStamp;

    public LiveStreamRepositoryIMPL(LiveStreamApiService liveStreamApiService) {
        this.liveStreamApiService = liveStreamApiService;
        timeStamp = System.currentTimeMillis();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }



    @Override
    public Observable<LiveStreamEntity> getLiveStream() {
        return liveStreamApiService.getLiveStream();
    }

    @Override
    public Observable<LiveStreamEntity> getLiveStreamFromCache() {
        return null;
    }

    @Override
    public Observable<LiveStreamEntity> getLiveStreamFromNetwork() {
        return liveStreamApiService.getLiveStream();
    }
}
