package com.nextnepal.nextNepalPatro.activityRashifal.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.DailyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.WeeklyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.DailyRashifalModel;
import com.nextnepal.nextNepalPatro.activityRashifal.model.WeeklyRashifalModel;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily.DailyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.daily.DailyRashifalRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityRashifal.presenter.DailyRashifalPresenter;
import com.nextnepal.nextNepalPatro.activityRashifal.presenter.WeeklyRashifalPresenter;
import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WeeklyRashifalModule {
    @Provides
    public WeeklyRashifalContract.Presenter provideNewsPresenter(WeeklyRashifalContract.Model model) {
        return new WeeklyRashifalPresenter(model);
    }

    @Provides
    public WeeklyRashifalContract.Model provideRashifalModel(WeeklyRashifalRepository rashifalRepository) {
        return new WeeklyRashifalModel(rashifalRepository);
    }

    @Singleton
    @Provides
    public WeeklyRashifalRepository provideNewsRepo(Context context, RashifalApiService rashifalApiService) {
        return new WeeklyRashifalRepositoryIMPL(context, rashifalApiService);
    }

}
