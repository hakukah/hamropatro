package com.nextnepal.nextNepalPatro.activityFriends.model.repositories;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendsListEntity;
import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class FriendsLIstRepositoryIMPL extends BaseRepository implements FriendsListRepository {
    private FriendsApiServices friendsApiServices;
    private Context context;
    private Disposable disposable;
    private long timeStamp;


    public FriendsLIstRepositoryIMPL(Context context, FriendsApiServices friendsApiServices) {
        this.friendsApiServices = friendsApiServices;
        this.context = context;
        timeStamp = System.currentTimeMillis();
    }

    @Override
    public Observable<FriendsListEntity> getFriendsFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getFriendsFromNetwork();
        }
    }

    @Override
    public Observable<FriendsListEntity> getFriendsFromNetwork() {
        disposable = friendsApiServices
                .getFriends("Bearer " + super.accessToken(context))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<FriendsListEntity>() {
                    @Override
                    public void onNext(FriendsListEntity friendsListEntities) {
                        storeCache(friendsListEntities);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return friendsApiServices.getFriends("Bearer " + super.accessToken(context));
    }

    @Override
    public Observable<FriendsListEntity> getFriends() {
        return friendsApiServices.getFriends("Bearer " + super.accessToken(context));
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_FOREX_MS;
    }

    private void storeCache(FriendsListEntity friendsListEntities) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_friends", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(friendsListEntities);
            editor.putString("friends", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_friends", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private FriendsListEntity retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_friends", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("friends", "");
        FriendsListEntity friendsListEntityList=gson.fromJson(json,FriendsListEntity.class);
        return friendsListEntityList;
    }
}
