package com.nextnepal.nextNepalPatro.activityForex.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nextnepal.nextNepalPatro.activityForex.contract.ForexContract;
import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;
import com.nextnepal.nextNepalPatro.util.values.WrapperError;

import java.lang.reflect.Type;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static com.nextnepal.nextNepalPatro.activityNews.presenter.NewsPresenter.API_STATUS_CODE_LOCAL_ERROR;

public class ForexPresenter implements ForexContract.Presenter {
    private ForexContract.View view;
    private ForexContract.Model model;
    private Disposable disposable;
    private Context context;

    public ForexPresenter(ForexContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.showLoading(true);
        }
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model.getForex()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<ForexEntity>>() {
                        @Override
                        public void onNext(List<ForexEntity> forexEntityList) {
                            if (view != null) {
                                view.loadData(forexEntityList);
                            }

                        }

                        @Override
                        public void onError(Throwable e) {
                            handleApiError(e);
                        }

                        @Override
                        public void onComplete() {
                            if (view != null)
                                view.showLoading(false);

                        }
                    });
        } else {
            view.showLoading(false);
            view.displayMessage("No Internet fetching old data");
            if (retrieveCache() != null) {
                view.loadData(retrieveCache());
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
    public void setView(ForexContract.View view) {
        this.view = view;
    }

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
