package com.nextnepal.nextNepalPatro.activitySignUp.presenter;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activitySignUp.contract.ActivitySignUpContract;
import com.nextnepal.nextNepalPatro.activitySignUp.model.dto.SignUpResponseEntity;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;
import com.nextnepal.nextNepalPatro.util.values.NetworkUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ActivitySignUpPresenter implements ActivitySignUpContract.Presenter {

    private Disposable disposable;
    private ActivitySignUpContract.View view;
    private ActivitySignUpContract.Model model;
    private Context context;

    public ActivitySignUpPresenter(ActivitySignUpContract.Model model, Context context) {
        this.model = model;
        this.context = context;
    }

    @Override
    public void setView(ActivitySignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void saveUsers(String firstName, String lastName, String username, String phone, String email, String password, String confirmPassword) {
        if (NetworkUtils.isNetworkConnected(context) && view != null) {
            view.showLoading(true);
            disposable = model.saveUsers(firstName, lastName, username, phone, email, password, confirmPassword)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribeWith(new DisposableObserver<SignUpResponseEntity>() {
                        @Override
                        public void onNext(SignUpResponseEntity signUpResponseEntity) {
                            view.showLoading(false);
                            view.displayMessage(signUpResponseEntity.getAccessToken());
                            view.transferActivity();
                        }

                        @Override
                        public void onError(Throwable e) {
                            view.displayMessage(e.getMessage());
                        }

                        @Override
                        public void onComplete() {
                            view.displayMessage(CONST.SUCCED);
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
}
