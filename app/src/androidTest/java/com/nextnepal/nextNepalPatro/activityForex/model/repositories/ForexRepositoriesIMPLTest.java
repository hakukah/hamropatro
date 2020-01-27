package com.nextnepal.nextNepalPatro.activityForex.model.repositories;

import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.activityForex.services.ForexApiService;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.*;

public class ForexRepositoriesIMPLTest {

    @Before
    public void setUp() throws Exception {
    }

    private long timeStamp;
    private List<ForexEntity> forexEntityList;
    private ForexApiService forexApiService;

//    public ForexRepositoriesIMPL(ForexApiService forexApiService) {
//        this.forexApiService = forexApiService;
//        timeStamp = System.currentTimeMillis();
//        forexEntityList = new ArrayList<>();
//    }

    @Test
    public Observable<List<ForexEntity>> getForex() {
        return getForexFromCahce().switchIfEmpty(getForexFromNetwork());
    }

    @Test
    public Observable<List<ForexEntity>> getForexFromCahce() {
        if (isUpToDate()) {
            return Observable.fromArray(forexEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            forexEntityList.clear();
            return Observable.empty();
        }
    }

    @Test
    public Observable<List<ForexEntity>> getForexFromNetwork() {
        List<ForexEntity> forexEntityList = new ArrayList<>();
        assertEquals(forexEntityList, forexApiService.getForex());
        return forexApiService.getForex();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }
}