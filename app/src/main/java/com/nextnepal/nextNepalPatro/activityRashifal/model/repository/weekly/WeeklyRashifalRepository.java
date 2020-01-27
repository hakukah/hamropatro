package com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly;

import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;

import io.reactivex.Observable;

public interface WeeklyRashifalRepository {
    Observable<RashifalEntity> getRashifalFromNetwork();

    Observable<RashifalEntity> getRashifalFromCache();

    Observable<RashifalEntity> getRashifal();
}
