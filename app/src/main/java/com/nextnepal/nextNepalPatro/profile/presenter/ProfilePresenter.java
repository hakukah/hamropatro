package com.nextnepal.nextNepalPatro.profile.presenter;

import android.content.Context;

import com.google.gson.JsonSyntaxException;
import com.nextnepal.nextNepalPatro.profile.contract.ProfileContract;
import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;
import com.nextnepal.nextNepalPatro.util.values.WrapperError;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static com.nextnepal.nextNepalPatro.activityNews.presenter.NewsPresenter.API_STATUS_CODE_LOCAL_ERROR;

public class ProfilePresenter extends BaseRepository implements ProfileContract.Presenter {

    private ProfileContract.View view;
    private ProfileContract.Model model;
    private Disposable disposable;
    private Context context;

    public ProfilePresenter(ProfileContract.Model model, Context context) {
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
                    .getProfileInfo()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<ProfileDto>() {
                        @Override
                        public void onNext(ProfileDto profileDto) {
                            if (view != null) {
                                view.loadProfileDetail(profileDto);
                            }
                        }
                        @Override
                        public void onError(Throwable e) {
                            handleApiError(e);
                        }

                        @Override
                        public void onComplete() {
                            if (view != null) {
                                view.showLoading(false);
                            }
                        }
                    });
        } else {
            view.showLoading(false);
            view.displayMessage("No Internet fetching old data");
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
    public void setView(ProfileContract.View view) {
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
}
