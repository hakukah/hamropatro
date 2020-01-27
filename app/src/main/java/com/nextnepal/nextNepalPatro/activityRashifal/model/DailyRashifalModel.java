package com.nextnepal.nextNepalPatro.activityRashifal.model;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.DailyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily.DailyRashifalRepository;

import io.reactivex.Observable;

public class DailyRashifalModel implements DailyRashifalContract.Model {
    private DailyRashifalRepository dailyRashifalRepository;

    public DailyRashifalModel(DailyRashifalRepository dailyRashifalRepository) {
        this.dailyRashifalRepository = dailyRashifalRepository;
    }

    @Override
    public Observable<RashifalEntity> getDailyRashifal() {
        return dailyRashifalRepository.getRashifal();
    }
}
