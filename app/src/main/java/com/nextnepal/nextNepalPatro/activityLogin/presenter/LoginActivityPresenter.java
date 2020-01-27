package com.nextnepal.nextNepalPatro.activityLogin.presenter;

import android.content.Context;

import com.google.gson.JsonSyntaxException;
import com.nextnepal.nextNepalPatro.activityLogin.contract.LoginActivityContract;
import com.nextnepal.nextNepalPatro.activityLogin.model.dto.LoginResponseDto;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;
import com.nextnepal.nextNepalPatro.util.values.WrapperError;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static com.nextnepal.nextNepalPatro.activityNews.presenter.NewsPresenter.API_STATUS_CODE_LOCAL_ERROR;

public class LoginActivityPresenter implements LoginActivityContract.Presenter {

    private LoginActivityContract.View view;
    private LoginActivityContract.Model model;
    private Disposable disposable;
    private Context context;

    public LoginActivityPresenter(LoginActivityContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(LoginActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void login(String email, String password) {
        if (view != null) {
            view.showLoading(true);
        }
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model.login(email, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<LoginResponseDto>() {
                        @Override
                        public void onNext(LoginResponseDto loginResponseDto) {
                            if (view != null) {
                                view.showLoading(false);
                                if (model.saveToken(loginResponseDto.getToken_type(), loginResponseDto.getExpires_in()
                                        , loginResponseDto.getAccess_token(), loginResponseDto.getRefresh_token())) {
                                    view.displayMessage(CONST.LOGIN_SUCCED);
                                    view.transferActivity();
                                } else {
                                    view.displayMessage(CONST.FAILED);
                                }
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
        } else {
            if (view != null) {
                view.displayMessage("Network not connected");
                view.showLoading(false);
            }
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
