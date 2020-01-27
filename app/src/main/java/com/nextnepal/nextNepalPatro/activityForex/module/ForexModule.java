package com.nextnepal.nextNepalPatro.activityForex.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityForex.contract.ForexContract;
import com.nextnepal.nextNepalPatro.activityForex.model.ForexModel;
import com.nextnepal.nextNepalPatro.activityForex.model.repositories.ForexRepositoriesIMPL;
import com.nextnepal.nextNepalPatro.activityForex.model.repositories.ForexRepository;
import com.nextnepal.nextNepalPatro.activityForex.services.ForexApiService;
import com.nextnepal.nextNepalPatro.activityForex.presenter.ForexPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ForexModule {
    @Provides
    public ForexContract.Presenter providePresenter(ForexContract.Model model, Context context) {
        return new ForexPresenter(model, context);
    }

    @Provides
    public ForexContract.Model provideModel(ForexRepository forexRepository) {
        return new ForexModel(forexRepository);
    }

    @Provides
    @Singleton
    public ForexRepository provideRepository(ForexApiService forexApiService, Context context) {
        return new ForexRepositoriesIMPL(forexApiService, context);
    }
}
