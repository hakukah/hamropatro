package com.nextnepal.nextNepalPatro.profile.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nextnepal.nextNepalPatro.profile.contract.ProfileContract;
import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.profile.model.repositories.ProfileRepository;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ProfileModel implements ProfileContract.Model {
    private ProfileRepository profileRepository;
    private Disposable disposable;
    private Context context;

    public ProfileModel(Context context, ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
        this.context = context;
    }

    @Override
    public Observable<ProfileDto> getProfileInfo() {
        disposable = profileRepository.getProfileInfo()
                .subscribeOn(Schedulers.io())
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

                    }
                });
        return profileRepository.getProfileInfo();
    }

    private void storeCache(ProfileDto profileDto) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("profile", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(profileDto);
            editor.putString("profile", json);
            editor.apply();
        } catch (Exception e) {
        }
    }

    private void clearCache() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("profile", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
    }


    private ProfileDto retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Cache_profile", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("friends", "");
        ProfileDto profileDto = gson.fromJson(json, ProfileDto.class);
        return profileDto;
    }


}
