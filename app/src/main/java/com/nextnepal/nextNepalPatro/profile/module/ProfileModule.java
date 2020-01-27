package com.nextnepal.nextNepalPatro.profile.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.profile.contract.ProfileContract;
import com.nextnepal.nextNepalPatro.profile.model.ProfileModel;
import com.nextnepal.nextNepalPatro.profile.presenter.ProfilePresenter;
import com.nextnepal.nextNepalPatro.profile.model.repositories.ProfileRepository;
import com.nextnepal.nextNepalPatro.profile.model.repositories.ProfileRepositoryIMPL;
import com.nextnepal.nextNepalPatro.profile.service.ProfileApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProfileModule {

    @Provides
    public ProfileContract.Presenter providesPresenter(ProfileContract.Model model, Context context) {
        return new ProfilePresenter(model, context);
    }

    @Provides
    public ProfileContract.Model providesModel(Context context, ProfileRepository profileRepository) {
        return new ProfileModel(context, profileRepository);
    }

    @Provides
    @Singleton
    public ProfileRepository providesRepository(Context context, ProfileApiService profileApiService) {
        return new ProfileRepositoryIMPL(context, profileApiService);
    }
}
