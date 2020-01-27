package com.nextnepal.nextNepalPatro.activityNews.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.nextnepal.nextNepalPatro.activityNews.contract.NewsContract;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.DataEntity;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsDto;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.Data;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.NewsEntity;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;
import com.nextnepal.nextNepalPatro.util.values.WrapperError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.View view;
    private Disposable disposable;
    private NewsContract.Model model;
    private Context context;

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public NewsPresenter(NewsContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.showLoading(true);
        }
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model
                    .getNews()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<NewsEntity>() {
                        @Override
                        public void onNext(NewsEntity newsEntity) {
                            if (view != null) {
                                newsEntity.getData().getClass().getCanonicalName();
//                                List<NewsDto> newsDtoList = new ArrayList<>();
//                                List<Data> dataEntityList = new ArrayList<>();
//                                for (int i = 0; i < newsEntity.getData().length; i++) {
//                                    dataEntityList.add(newsEntity.getData());
//                                }
                                //  newsDtoList.add(newsDto);
                                view.updateData(Arrays.asList(newsEntity.getData()));
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            handleApiError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
//            disposable = model
//                    .getNews()
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribeWith(new DisposableObserver<NewsDto>() {
//                        @Override
//                        public void onNext(NewsDto newsDto) {
//                            if (view != null) {
////                                newsDto.getData().getClass().getCanonicalName();
////                                List<NewsDto> newsDtoList = new ArrayList<>();
//                                List<Data> dataEntityList = new ArrayList<>();
//                                for (int i = 0; i < newsDto.getData().getItem().size(); i++) {
//                                    dataEntityList.add(newsDto.getData());
//                                }
//                                //  newsDtoList.add(newsDto);
//                                view.updateData(dataEntityList);
//                            }
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            handleApiError(e);
//                        }
//
//                        @Override
//                        public void onComplete() {
//
//                        }
//                    });
        } else {
            if (view != null) {
                view.displayMessage("No Internet fetching old data");
                view.showLoading(false);
                List<DataEntity> dataEntityList = new ArrayList<>();
                if (retrieveCache() != null) {
                    view.updateData(Arrays.asList(retrieveCache().getData()));
//                    for (int i = 0; i < retrieveCache().getData().getItem().size(); i++) {
//                        dataEntityList.add(retrieveCache().getData());
//                    }
//                    view.updateData(dataEntityList);
                }
            }
        }

    }

    @Override
    public void rxUnsubscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }


    @Override
    public void setView(NewsContract.View view) {
        this.view = view;
        view.initView();
    }

    @Override
    public void handleApiError(Throwable error) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    view.displayMessage("Unauthorised User");
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    view.displayMessage("Forbidden");
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    view.displayMessage("Internal Server Error");
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    view.displayMessage("Bad Request");
                    break;
                case HttpsURLConnection.HTTP_CLIENT_TIMEOUT:
                    view.displayMessage("Quitting");
                    break;
                case API_STATUS_CODE_LOCAL_ERROR:
                    view.displayMessage("No Internet Connection");
                    break;
                default:
                    view.displayMessage(error.getLocalizedMessage());
            }
        } else if (error instanceof WrapperError) {
            view.displayMessage(error.getMessage());
        } else if (error instanceof JsonSyntaxException) {
            view.displayMessage("Something Went Wrong API is not responding properly!");
        } else {
            view.displayMessage(error.getMessage());
        }

    }

    private NewsEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_news", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("news", "");
        NewsEntity allEquipmentProductEntity = gson.fromJson(json, NewsEntity.class);
        return allEquipmentProductEntity;
    }
}
