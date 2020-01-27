package com.nextnepal.nextNepalPatro.activityRashifal.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityRashifal.contract.WeeklyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.YearlyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.WeeklyRashifalModel;
import com.nextnepal.nextNepalPatro.activityRashifal.model.YearlyRashifalModel;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.weekly.WeeklyRashifalRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.yearly.YearlyRashifalRepository;
import com.nextnepal.nextNepalPatro.activityRashifal.model.repository.yearly.YearlyRashifalRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityRashifal.presenter.WeeklyRashifalPresenter;
import com.nextnepal.nextNepalPatro.activityRashifal.presenter.YearlyRashifalPresenter;
import com.nextnepal.nextNepalPatro.activityRashifal.services.RashifalApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class YearlyRashifalModule {
    @Provides
    public YearlyRashifalContract.Presenter provideNewsPresenter(YearlyRashifalContract.Model model) {
        return new YearlyRashifalPresenter(model);
    }

    @Provides
    public YearlyRashifalContract.Model provideRashifalModel(YearlyRashifalRepository rashifalRepository) {
        return new YearlyRashifalModel(rashifalRepository);
    }

    @Singleton
    @Provides
    public YearlyRashifalRepository provideNewsRepo(Context context, RashifalApiService rashifalApiService) {
        return new YearlyRashifalRepositoryIMPL(context, rashifalApiService);
    }

}
