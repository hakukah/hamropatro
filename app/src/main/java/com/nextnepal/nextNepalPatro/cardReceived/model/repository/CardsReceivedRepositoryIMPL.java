package com.nextnepal.nextNepalPatro.cardReceived.model.repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;
import com.nextnepal.nextNepalPatro.cardReceived.model.dto.CardReceivedDto;
import com.nextnepal.nextNepalPatro.cardReceived.service.CardsApiService;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CardsReceivedRepositoryIMPL extends BaseRepository implements CardsReceivedRepository {

    private CardsApiService cardsApiService;
    private Disposable disposable;
    private Context context;
    private long timeStamp;

    public CardsReceivedRepositoryIMPL(Context context, CardsApiService cardsApiService) {
        this.cardsApiService = cardsApiService;
        this.context = context;
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public Observable<List<CardReceivedDto>> getCards() {
        return getCardsFromCache().switchIfEmpty(getCardsFromNetwork());

    }

    @Override
    public Observable<List<CardReceivedDto>> getCardsFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getCardsFromNetwork();
        }
    }

    @Override
    public Observable<List<CardReceivedDto>> getCardsFromNetwork() {
        disposable =
                cardsApiService
                        .getCards("Bearer " + super.accessToken(context))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<List<CardReceivedDto>>() {
                            @Override
                            public void onNext(List<CardReceivedDto> cardReceivedDtoList) {
                                storeCache(cardReceivedDtoList);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
        return cardsApiService.getCards("Bearer " + super.accessToken(context));

    }

    private void storeCache(List<CardReceivedDto> cardReceivedDtoList) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_cards_received", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(cardReceivedDtoList);
            editor.putString("cards_received", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_cards_received", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private List<CardReceivedDto> retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_cards_received", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("cards_received", "");
        Type list = new TypeToken<List<CardSelectionEntity>>() {
        }.getType();
        List<CardReceivedDto> cardReceivedDtoList = gson.fromJson(json, list);
        return cardReceivedDtoList;
    }


    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_FOREX_MS;
    }
}
