package com.nextnepal.nextNepalPatro.activityForex.model.repositories;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.activityForex.services.ForexApiService;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ForexRepositoriesIMPL implements ForexRepository {

    private long timeStamp;
    private List<ForexEntity> forexEntityList;
    private ForexApiService forexApiService;
    private Context context;
    private Disposable disposable;

    public ForexRepositoriesIMPL(ForexApiService forexApiService, Context context) {
        this.forexApiService = forexApiService;
        timeStamp = System.currentTimeMillis();
        forexEntityList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public Observable<List<ForexEntity>> getForex() {
        return getForexFromCahce().switchIfEmpty(getForexFromNetwork());
    }

    @Override
    public Observable<List<ForexEntity>> getForexFromCahce() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getForexFromNetwork();
        }
    }

    @Override
    public Observable<List<ForexEntity>> getForexFromNetwork() {
        disposable = forexApiService
                .getForex()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<List<ForexEntity>>() {
                    @Override
                    public void onNext(List<ForexEntity> forexEntities) {
                        storeCache(forexEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        disposable.dispose();
                    }
                });
        return forexApiService.getForex();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_FOREX_MS;
    }

    private void storeCache(List<ForexEntity> forexEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_forex", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(forexEntity);
            editor.putString("forex", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_forex", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private List<ForexEntity> retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_forex", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("forex", "");
        Type list = new TypeToken<List<ForexEntity>>() {
        }.getType();
        List<ForexEntity> forexEntityList = gson.fromJson(json, list);
        return forexEntityList;
    }


}
