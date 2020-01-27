package com.nextnepal.nextNepalPatro.profile.model.repositories;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.profile.service.ProfileApiService;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfileRepositoryIMPL extends BaseRepository implements ProfileRepository {
    private ProfileApiService profileApiService;
    private Context context;
    private Disposable disposable;
    private long timeStamp;

    public ProfileRepositoryIMPL(Context context, ProfileApiService profileApiService) {
        this.context = context;
        this.profileApiService = profileApiService;
        this.timeStamp = System.currentTimeMillis();
    }

    @Override
    public Observable<ProfileDto> getProfileInfo() {
        return getProfileFromCache().switchIfEmpty(getProfileFromNetwork());
    }

    @Override
    public Observable<ProfileDto> getProfileFromCache() {
        if (isUpToDate() && retrieveCache() != null) {
            return Observable.fromArray(retrieveCache());
        } else {
            timeStamp = System.currentTimeMillis();
            clearCache();
            return getProfileFromNetwork();
        }
    }

    @Override
    public Observable<ProfileDto> getProfileFromNetwork() {
        disposable = profileApiService
                .getProfileInfo("Bearer " + accessToken(context))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ProfileDto>() {
                    @Override
                    public void onNext(ProfileDto profileDto) {
                        storeCache(profileDto);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        disposable.dispose();
                    }
                });
        return profileApiService.getProfileInfo("Bearer " + accessToken(context));
    }

    private void storeCache(ProfileDto profileDto) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_profile", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(profileDto);
            editor.putString("profile", json);
            editor.commit();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_profile", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }

    private ProfileDto retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_profile", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("profile", "");
        ProfileDto profileDto = gson.fromJson(json, ProfileDto.class);
        return profileDto;
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_FOREX_MS;
    }
}
