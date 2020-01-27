package com.nextnepal.nextNepalPatro.activityNews.services;

import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsDto;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.NewsEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NewsApiService {

    @GET("admin/newsrss")
    Observable<NewsEntity> getNews();
}
