package com.nextnepal.nextNepalPatro.activityRashifal.presenter;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.WeeklyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.YearlyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalDto;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class YearlyRashifalPresenter implements YearlyRashifalContract.Presenter {

    private YearlyRashifalContract.View view;
    private YearlyRashifalContract.Model model;
    private Disposable disposable;


    public YearlyRashifalPresenter(YearlyRashifalContract.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        disposable = model
                .getYearlyRashifal()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<RashifalEntity>() {
                    @Override
                    public void onNext(RashifalEntity rashifalEntity) {
                        if (view != null) {
                            view.setDate(rashifalEntity.getDates());
                            List<RashifalDto> rashifalEntityList = new ArrayList<>();
                            for (int i = 0; i < rashifalEntity.getData().size(); i++) {
                                rashifalEntityList.add(rashifalEntity.getData().get(i));
                            }
                            view.updateData(rashifalEntityList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void rxUnsubscribe() {

    }


    @Override
    public void setView(YearlyRashifalContract.View view) {
        this.view = view;
    }
}
