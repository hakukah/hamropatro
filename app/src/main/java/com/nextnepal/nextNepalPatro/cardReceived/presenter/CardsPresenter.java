package com.nextnepal.nextNepalPatro.cardReceived.presenter;

import android.widget.Toast;

import com.google.gson.JsonSyntaxException;
import com.nextnepal.nextNepalPatro.cardReceived.contract.CardsReceivedContract;
import com.nextnepal.nextNepalPatro.cardReceived.model.dto.CardReceivedDto;
import com.nextnepal.nextNepalPatro.util.values.WrapperError;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

import static com.nextnepal.nextNepalPatro.activityNews.presenter.NewsPresenter.API_STATUS_CODE_LOCAL_ERROR;

public class CardsPresenter implements CardsReceivedContract.Presenter {
    private CardsReceivedContract.View view;
    private CardsReceivedContract.Model model;
    private Disposable disposable;

    public CardsPresenter(CardsReceivedContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(CardsReceivedContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (view != null) {
            disposable = model
                    .getCards()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<CardReceivedDto>>() {
                        @Override
                        public void onNext(List<CardReceivedDto> cardReceivedDtos) {
                            if (view != null) {
                                view.receivedCard(cardReceivedDtos);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (view != null) {
                                handleApiError(e);
                            }
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
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
