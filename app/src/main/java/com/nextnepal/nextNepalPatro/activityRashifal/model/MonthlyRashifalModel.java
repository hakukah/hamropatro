package com.nextnepal.nextNepalPatro.activityRashifal.model;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.DailyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.MonthlyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily.DailyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.monthly.MonthlyRashifalRepository;

import io.reactivex.Observable;

public class MonthlyRashifalModel implements MonthlyRashifalContract.Model {
    private MonthlyRashifalRepository monthlyRashifalRepository;

    public MonthlyRashifalModel(MonthlyRashifalRepository monthlyRashifalRepository) {
        this.monthlyRashifalRepository = monthlyRashifalRepository;
    }

    @Override
    public Observable<RashifalEntity> getMonthlyRashifal() {
        return monthlyRashifalRepository.getRashifal();
    }
}
