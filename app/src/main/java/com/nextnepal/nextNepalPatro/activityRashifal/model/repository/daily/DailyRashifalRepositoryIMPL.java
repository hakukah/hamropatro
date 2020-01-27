package com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;
import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DailyRashifalRepositoryIMPL implements DailyRashifalRepository {

    private RashifalApiService rashifalApiService;
    private Disposable disposable;
    private long timeStamp;
    private Context context;

    public DailyRashifalRepositoryIMPL(Context context, RashifalApiService rashifalApiService) {
        this.rashifalApiService = rashifalApiService;
        this.context = context;
    }

    @Override
    public Observable<RashifalEntity> getRashifalFromNetwork() {
        disposable = rashifalApiService.getRashifalDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<RashifalEntity>() {
                    @Override
                    public void onNext(RashifalEntity rashifalEntity) {
                        storeCache(rashifalEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        disposable.dispose();
                    }
                });
        return rashifalApiService.getRashifalDaily();
    }

    @Override
    public Observable<RashifalEntity> getRashifalFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getRashifalFromNetwork();
        }
    }

    @Override
    public Observable<RashifalEntity> getRashifal() {
        return getRashifalFromCache().switchIfEmpty(getRashifalFromNetwork());
    }

    private void storeCache(RashifalEntity rashifalEntity) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_rashifal_daily", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(rashifalEntity);
            editor.putString("rashifal_daily", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_rashifal_daily", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private RashifalEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_rashifal_daily", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("rashifal_daily", "");
        RashifalEntity rashifalEntity = gson.fromJson(json, RashifalEntity.class);
        return rashifalEntity;
    }


    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_RASHIFAL_MS;
    }
}
