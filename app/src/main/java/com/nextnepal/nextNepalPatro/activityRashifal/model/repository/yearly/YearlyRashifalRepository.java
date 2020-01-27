package com.nextnepal.nextNepalPatro.activityRashifal.model.repository.yearly;

import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;

import io.reactivex.Observable;

public interface YearlyRashifalRepository {
    Observable<RashifalEntity> getRashifalFromNetwork();

    Observable<RashifalEntity> getRashifalFromCache();

    Observable<RashifalEntity> getRashifal();
}
