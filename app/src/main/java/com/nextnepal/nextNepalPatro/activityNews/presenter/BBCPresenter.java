package com.nextnepal.nextNepalPatro.activityNews.presenter;

import com.nextnepal.nextNepalPatro.activityNews.contract.BBCContract;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.BBC.BBCDto;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BBCPresenter implements BBCContract.Presenter {

    private BBCContract.View view;
    private Disposable subscription;
    private BBCContract.Model model;

    public BBCPresenter(BBCContract.Model model) {
        this.model = model;
    }

    @Override
    public void setView(BBCContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        subscription = model
                .getBBCNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<BBCDto>() {
                            @Override
                            public void accept(BBCDto bbcDto) throws Exception {
                                List<BBCDto> bbcDtoList = new ArrayList<>();
                                bbcDtoList.add(bbcDto);
                                view.loadBBcNews(bbcDtoList);
                            }
                        }
                );
    }

    @Override
    public void rxUnsuscribe() {
        if (subscription != null) {
            if (!subscription.isDisposed()) {
                subscription.dispose();
            }
        }
    }
}
