package com.nextnepal.nextNepalPatro.myCard.presenter;

import android.content.Context;

import com.nextnepal.nextNepalPatro.myCard.contract.CardSelectionContract;
import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CardSelectionPresenter implements CardSelectionContract.Presenter {

    private CardSelectionContract.View view_ic;
    private CardSelectionContract.Model model_ic;
    private Disposable disposable;
    private Context context;


    public CardSelectionPresenter(CardSelectionContract.Model model_ic, Context context) {
        this.model_ic = model_ic;
        this.context = context;
    }

    @Override
    public void setView(CardSelectionContract.View view_ic) {
        this.view_ic = view_ic;
    }

    @Override
    public void loadData() {
        if (view_ic != null) {
            view_ic.showLoading(false);
        }
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model_ic
                    .getCard()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<CardSelectionEntity>>() {
                        @Override
                        public void onNext(List<CardSelectionEntity> cardSelectionEntities) {
                            if (view_ic != null) {
                                view_ic.showLoading(false);
                                view_ic.loadCard(cardSelectionEntities);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            view_ic.displayMessage(e.getLocalizedMessage());
                        }

                        @Override
                        public void onComplete() {
                            if (view_ic != null) {
                                view_ic.showLoading(false);
                            }
                        }
                    });
        } else {
            view_ic.showLoading(false);
            view_ic.displayMessage("No Internet fetching old data");
//            if (retrieveCache() != null) {
//                view.loadData(retrieveCache());
//            }
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
}
