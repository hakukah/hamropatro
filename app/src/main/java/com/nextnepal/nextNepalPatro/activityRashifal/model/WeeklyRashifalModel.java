package com.nextnepal.nextNepalPatro.activityRashifal.model;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.DailyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.WeeklyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily.DailyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepository;

import io.reactivex.Observable;

public class WeeklyRashifalModel implements WeeklyRashifalContract.Model {
    private WeeklyRashifalRepository weeklyRashifalRepository;

    public WeeklyRashifalModel(WeeklyRashifalRepository weeklyRashifalRepository) {
        this.weeklyRashifalRepository = weeklyRashifalRepository;
    }

    @Override
    public Observable<RashifalEntity> getWeeklyRashifal() {
        return weeklyRashifalRepository.getRashifal();
    }
}
