package com.nextnepal.nextNepalPatro.activityRashifal.model.repository.monthly;

import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;

import io.reactivex.Observable;

public interface MonthlyRashifalRepository {
    Observable<RashifalEntity> getRashifalFromNetwork();

    Observable<RashifalEntity> getRashifalFromCache();

    Observable<RashifalEntity> getRashifal();
}
