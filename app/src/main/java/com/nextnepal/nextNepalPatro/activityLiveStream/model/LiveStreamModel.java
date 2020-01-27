package com.nextnepal.nextNepalPatro.activityLiveStream.model;

import com.nextnepal.nextNepalPatro.activityLiveStream.contract.LiveStreamContract;
import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamEntity;
import com.nextnepal.nextNepalPatro.activityLiveStream.repository.LiveStreamRepository;

import io.reactivex.Observable;

public class LiveStreamModel implements LiveStreamContract.Model {
    private LiveStreamRepository liveStreamRepository;

    public LiveStreamModel(LiveStreamRepository liveStreamRepository) {
        this.liveStreamRepository = liveStreamRepository;
    }

    @Override
    public Observable<LiveStreamEntity> getLiveStream() {
        return liveStreamRepository.getLiveStream();
    }
}
