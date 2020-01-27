package com.nextnepal.nextNepalPatro.activityForex.model.repositories;

import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;

import java.util.List;

import io.reactivex.Observable;

public interface ForexRepository {
    Observable<List<ForexEntity>> getForex();

    Observable<List<ForexEntity>> getForexFromCahce();

    Observable<List<ForexEntity>> getForexFromNetwork();
}
