package com.nextnepal.nextNepalPatro.activityRashifal.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.DailyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalDto;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;
import com.nextnepal.nextNepalPatro.util.values.WrapperError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static com.nextnepal.nextNepalPatro.activityNews.presenter.NewsPresenter.API_STATUS_CODE_LOCAL_ERROR;

public class DailyRashifalPresenter implements DailyRashifalContract.Presenter {

    private DailyRashifalContract.View view;
    private DailyRashifalContract.Model model;
    private Disposable disposable;
    private Context context;


    public DailyRashifalPresenter(DailyRashifalContract.Model model, Context context) {
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
                    .getDailyRashifal()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<RashifalEntity>() {
                        @Override
                        public void onNext(RashifalEntity rashifalEntity) {
                            if (view != null) {
                                view.setDate(rashifalEntity.getDates());
                                List<RashifalDto> rashifalEntityList = new ArrayList<>();
                                for (int i = 0; i < rashifalEntity.getData().size(); i++) {
                                    rashifalEntityList.add(rashifalEntity.getData().get(i));
                                }
                                view.updateData(rashifalEntityList);
                                view.showLoading(false);
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
        } else {
            view.showLoading(false);
            view.displayMessage("No Internet fetching old data");
            if (retrieveCache() != null) {
                List<RashifalDto> rashifalEntityList = new ArrayList<>();
                for (int i = 0; i < retrieveCache().getData().size(); i++) {
                    rashifalEntityList.add(retrieveCache().getData().get(i));
                }
                view.updateData(rashifalEntityList);
            }
        }
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

    @Override
    public void rxUnsubscribe() {
        if (disposable != null)
            if (disposable.isDisposed()) {
                disposable.dispose();
            }
    }


    @Override
    public void setView(DailyRashifalContract.View view) {
        this.view = view;
    }

    private RashifalEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_rashifal_daily", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("rashifal_daily", "");
        RashifalEntity rashifalEntity = gson.fromJson(json, RashifalEntity.class);
        return rashifalEntity;
    }
}
