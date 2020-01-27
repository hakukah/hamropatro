package com.nextnepal.nextNepalPatro.activityNews.model.repository;

import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsDto;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.NewsEntity;

import io.reactivex.Observable;

public interface NewsRepositories {
    Observable<NewsEntity> getNewsFromCache();

    Observable<NewsEntity> getNewsFromNetwork();

    Observable<NewsEntity> getNews();
}
