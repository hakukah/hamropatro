package com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily;

import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;

import io.reactivex.Observable;

public interface DailyRashifalRepository {
    Observable<RashifalEntity> getRashifalFromNetwork();

    Observable<RashifalEntity> getRashifalFromCache();

    Observable<RashifalEntity> getRashifal();
}
