package com.nextnepal.nextNepalPatro.myCard.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;
import com.nextnepal.nextNepalPatro.myCard.service.CardSelectionApi;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CardRepositoryIMPL extends BaseRepository implements CardRepository {

    private CardSelectionApi cardSelectionApi;
    private Context context;
    private long timeStamp;
    private Disposable disposable;

    public CardRepositoryIMPL(Context context, CardSelectionApi cardSelectionApi) {
        this.cardSelectionApi = cardSelectionApi;
        this.context = context;
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public Observable<List<CardSelectionEntity>> getCardFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getCardFromNetwork();
        }
    }

    @Override
    public Observable<List<CardSelectionEntity>> getCardFromNetwork() {
        disposable = cardSelectionApi
                .getCard("Bearer " + super.accessToken(context))
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<List<CardSelectionEntity>>() {
                    @Override
                    public void onNext(List<CardSelectionEntity> cardSelectionEntities) {
                        storeCache(cardSelectionEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return cardSelectionApi.getCard("Bearer " + super.accessToken(context));
    }

    @Override
    public Observable<List<CardSelectionEntity>> getCard() {
        return getCardFromCache().switchIfEmpty(getCardFromNetwork());

    }

    private void storeCache(List<CardSelectionEntity> cardSelectionEntities) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_cards", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(cardSelectionEntities);
            editor.putString("cards", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_cards", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private List<CardSelectionEntity> retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_cards", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("cards", "");
        Type list = new TypeToken<List<CardSelectionEntity>>() {
        }.getType();
        List<CardSelectionEntity> cardSelectionEntities = gson.fromJson(json, list);
        return cardSelectionEntities;
    }


    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_FOREX_MS;
    }
}
