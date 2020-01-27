package com.nextnepal.nextNepalPatro.activityFriends.presenter;

import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsListContract;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendsListEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class FriendsListPresenter implements FriendsListContract.Presenter {
    private FriendsListContract.View view;
    private FriendsListContract.Model model;
    private Disposable disposable;

    public FriendsListPresenter(FriendsListContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(FriendsListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {

        disposable = model.getFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FriendsListEntity>() {
                    @Override
                    public void onNext(FriendsListEntity friendsListEntity) {
                        if (view != null)
                            view.loadFriends(friendsListEntity.getData());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        //        disposable = model.getFriends()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableObserver<List<FriendsListEntity>>() {
//                    @Override
//                    public void onNext(List<FriendsListEntity> friendsListEntities) {
//                        if (view != null)
//                            view.displayMessage(String.valueOf(friendsListEntities.size()));
//                        view.loadFriends(friendsListEntities);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    public void rxUnsubscribe() {
        if (disposable != null)
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
    }
}
