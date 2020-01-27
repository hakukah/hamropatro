package com.nextnepal.nextNepalPatro.activityRashifal.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.DailyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.DailyRashifalModel;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily.DailyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily.DailyRashifalRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityRashifal.presenter.DailyRashifalPresenter;
import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DailyRashifalModule {
    @Provides
    public DailyRashifalContract.Presenter provideNewsPresenter(DailyRashifalContract.Model model,Context context) {
        return new DailyRashifalPresenter(model,context);
    }

    @Provides
    public DailyRashifalContract.Model provideRashifalModel(DailyRashifalRepository rashifalRepository) {
        return new DailyRashifalModel(rashifalRepository);
    }

    @Singleton
    @Provides
    public DailyRashifalRepository provideNewsRepo(Context context, RashifalApiService rashifalApiService) {
        return new DailyRashifalRepositoryIMPL(context, rashifalApiService);
    }

}
