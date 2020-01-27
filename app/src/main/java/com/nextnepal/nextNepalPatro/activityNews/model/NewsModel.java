package com.nextnepal.nextNepalPatro.activityNews.model;

import com.nextnepal.nextNepalPatro.activityNews.contract.NewsContract;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsDto;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.NewsEntity;
import com.nextnepal.nextNepalPatro.activityNews.model.repository.NewsRepositories;

import io.reactivex.Observable;

public class NewsModel implements NewsContract.Model {

    private NewsRepositories newsRepositories;

    public NewsModel(NewsRepositories newsRepositories) {
        this.newsRepositories = newsRepositories;
    }

    @Override
    public Observable<NewsEntity> getNews() {
        return newsRepositories.getNews();
    }
}
