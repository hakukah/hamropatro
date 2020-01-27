package com.nextnepal.nextNepalPatro.activityRashifal.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.MonthlyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.WeeklyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.MonthlyRashifalModel;
import com.nextnepal.nextNepalPatro.activityRashifal.model.WeeklyRashifalModel;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.monthly.MonthlyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.monthly.MonthlyRashifalRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityRashifal.presenter.MonthlyRashifalPresenter;
import com.nextnepal.nextNepalPatro.activityRashifal.presenter.WeeklyRashifalPresenter;
import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MonthlyRashifalModule {
    @Provides
    public MonthlyRashifalContract.Presenter provideNewsPresenter(MonthlyRashifalContract.Model model) {
        return new MonthlyRashifalPresenter(model);
    }

    @Provides
    public MonthlyRashifalContract.Model provideRashifalModel(MonthlyRashifalRepository monthlyRashifalRepository) {
        return new MonthlyRashifalModel(monthlyRashifalRepository);
    }

    @Singleton
    @Provides
    public MonthlyRashifalRepository provideNewsRepo(Context context, RashifalApiService rashifalApiService) {
        return new MonthlyRashifalRepositoryIMPL(context, rashifalApiService);
    }

}
