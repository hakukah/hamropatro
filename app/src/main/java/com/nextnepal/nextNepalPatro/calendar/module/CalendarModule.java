package com.nextnepal.nextNepalPatro.calendar.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.calendar.contract.CalendarContract;
import com.nextnepal.nextNepalPatro.calendar.model.CalendarModel;
import com.nextnepal.nextNepalPatro.calendar.presenter.CalendarPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class CalendarModule {
    @Provides
    public CalendarContract.Model providesModel(Context context) {
        return new CalendarModel(context);
    }

    @Provides
    public CalendarContract.Presenter providesPresenter(CalendarContract.Model model) {
        return new CalendarPresenter(model);
    }

}
