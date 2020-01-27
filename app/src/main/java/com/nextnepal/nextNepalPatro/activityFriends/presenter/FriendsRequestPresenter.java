package com.nextnepal.nextNepalPatro.activityFriends.presenter;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsRequestContract;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class FriendsRequestPresenter implements FriendsRequestContract.Presenter {
    private FriendsRequestContract.View view;
    private FriendsRequestContract.Model model;
    private Disposable disposable;
    private Context context;

    public FriendsRequestPresenter(FriendsRequestContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(FriendsRequestContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (NetworkUtils.isNetworkConnected(context)) {
            disposable = model.getFriends()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new DisposableObserver<List<UsersEntity>>() {
                        @Override
                        public void onNext(List<UsersEntity> usersEntityList) {
                            if (view != null) {
                                if (usersEntityList.size() <= 0) {
                                    view.displayMessage(CONST.FRIENDS_NULL);
                                } else {
                                    view.loadFriends(usersEntityList);
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
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
