package com.nextnepal.nextNepalPatro.activityLiveStream.presenter;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityLiveStream.contract.LiveStreamContract;
import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamEntity;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LiveStreamPresenter implements LiveStreamContract.Presenter {

    private LiveStreamContract.Model model;
    private LiveStreamContract.View view;
    private Disposable disposable;
    private Context context;

    public LiveStreamPresenter(LiveStreamContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(LiveStreamContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (NetworkUtils.isNetworkConnected(context) && view != null) {
            view.showLoading(true);
            disposable = model.getLiveStream()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<LiveStreamEntity>() {
                        @Override
                        public void onNext(LiveStreamEntity liveStreamEntity) {
                            view.showLoading(false);
                            view.loadData(liveStreamEntity.getData());
                        }

                        @Override
                        public void onError(Throwable e) {

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
    public void rxUnsubscribe() {
        if (disposable != null) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
