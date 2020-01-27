package com.nextnepal.nextNepalPatro.activityNews.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsDto;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.NewsEntity;
import com.nextnepal.nextNepalPatro.activityNews.services.NewsApiService;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsRepositoryIMPL implements NewsRepositories {
    private NewsApiService newsApiService;
    List<NewsDto> newsDtoList;
    private long timeStamp;
    private Context context;
    private Disposable disposable;

    public NewsRepositoryIMPL(NewsApiService newsApiService, Context context) {
        this.newsApiService = newsApiService;
        this.timeStamp = System.currentTimeMillis();
        newsDtoList = new ArrayList<>();
        this.context = context;
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }

    @Override
    public Observable<NewsEntity> getNewsFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getNewsFromNetwork();
        }
    }

    @Override
    public Observable<NewsEntity> getNewsFromNetwork() {
        disposable=newsApiService.getNews()
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<NewsEntity>() {
                    @Override
                    public void onNext(NewsEntity newsEntity) {
                        storeCache(newsEntity);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
//        disposable = newsApiService.getNews()
//                .subscribeOn(Schedulers.io())
//                .subscribeWith(new DisposableObserver<NewsEntity>() {
//                    @Override
//                    public void onNext(NewsDto newsDto) {
//                        storeCache(NewsEntity);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
        return newsApiService.getNews();
    }

    @Override
    public Observable<NewsEntity> getNews() {
        return getNewsFromCache().switchIfEmpty(getNewsFromNetwork());
    }

    private void storeCache(NewsEntity newsDto) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_news", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(newsDto);
            editor.putString("news", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_news", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private NewsEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_news", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("news", "");
        NewsEntity allEquipmentProductEntity = gson.fromJson(json, NewsEntity.class);
        return allEquipmentProductEntity;
    }
}
