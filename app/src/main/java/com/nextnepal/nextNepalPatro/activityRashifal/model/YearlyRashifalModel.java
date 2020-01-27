package com.nextnepal.nextNepalPatro.activityRashifal.model;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.WeeklyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.YearlyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.yearly.YearlyRashifalRepository;

import io.reactivex.Observable;

public class YearlyRashifalModel implements YearlyRashifalContract.Model {
    private YearlyRashifalRepository yearlyRashifalRepository;

    public YearlyRashifalModel(YearlyRashifalRepository yearlyRashifalRepository) {
        this.yearlyRashifalRepository = yearlyRashifalRepository;
    }

    @Override
    public Observable<RashifalEntity> getYearlyRashifal() {
        return yearlyRashifalRepository.getRashifal();
    }
}
