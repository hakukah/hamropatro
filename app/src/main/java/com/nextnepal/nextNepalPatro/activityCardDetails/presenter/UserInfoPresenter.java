package com.nextnepal.nextNepalPatro.activityCardDetails.presenter;

import android.content.Context;

import com.google.gson.JsonSyntaxException;
import com.nextnepal.nextNepalPatro.activityCardDetails.contract.UserInfoContract;
import com.nextnepal.nextNepalPatro.activityCardDetails.model.dto.UserInfoEntity;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;
import com.nextnepal.nextNepalPatro.util.values.WrapperError;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static com.nextnepal.nextNepalPatro.activityNews.presenter.NewsPresenter.API_STATUS_CODE_LOCAL_ERROR;

public class UserInfoPresenter implements UserInfoContract.Presenter {
    UserInfoContract.View view;
    UserInfoContract.Model model;
    private Disposable disposable;
    private Context context;

    public UserInfoPresenter(UserInfoContract.Model model, Context context) {

        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(UserInfoContract.View view) {
        this.view = view;
    }

    @Override
    public void addDetails(UserInfoEntity userInfoEntity) {
        if (NetworkUtils.isNetworkConnected(context) && view != null) {
            view.showLoading(true);
            disposable = model
                    .addDetails(userInfoEntity)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<BaseResponse>() {
                        @Override
                        public void onNext(BaseResponse baseResponse) {
                            if (view != null) {
                                view.showLoading(false);
                                view.displayMessage("Detail's updated");
                                view.transferActivity();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (view != null) {
                                view.showLoading(false);
                            }
                            handleApiError(e);
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else if (view != null) {
            view.displayMessage("Network not connected");
        }
    }

    @Override
    public void loadData() {

    }

    @Override
    public void rxUnsubscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }

    public void handleApiError(Throwable error) {
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    view.displayMessage("Username or Password Incorrect");
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
}
