package com.nextnepal.nextNepalPatro.activityUsers.presenter;

import android.util.Log;

import com.nextnepal.nextNepalPatro.activityUsers.contract.UsersContract;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class UserListPresenter implements UsersContract.Presenter {
    private UsersContract.View view;
    private UsersContract.Model model;
    private Disposable disposable;

    public UserListPresenter(UsersContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(UsersContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        disposable = model
                .getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<UsersEntity>>() {
                    @Override
                    public void onNext(List<UsersEntity> usersEntityList) {
                        view.loadUserList(usersEntityList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.displayMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

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
