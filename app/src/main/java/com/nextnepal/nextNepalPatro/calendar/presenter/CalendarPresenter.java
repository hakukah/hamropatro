package com.nextnepal.nextNepalPatro.calendar.presenter;

import android.content.Context;

import com.nextnepal.nextNepalPatro.calendar.contract.CalendarContract;

import io.reactivex.disposables.Disposable;

import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.ISCURRENT;
import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.SELECTED_MONTH;
import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.SELECTED_YEAR;

public class CalendarPresenter implements CalendarContract.Presenter {
    private Disposable disposable;
    private CalendarContract.Model model;
    private CalendarContract.View view;

    public CalendarPresenter(CalendarContract.Model model) {
        this.model = model;
    }

    public void loadData(Context context) {
    }

    @Override
    public void loadData() {
        if (ISCURRENT) {
            SELECTED_MONTH = model.getCurrentDatesNep().getMonth();
            SELECTED_YEAR = model.getCurrentDatesNep().getYear();
            ISCURRENT = false;
        }
        view.loadCalendar(model.getSelectedMonths(SELECTED_YEAR,
                SELECTED_MONTH + 1));

        view.loadDefaultMonth(model.getCurrentDatesNep().getYear(),
                model.getStringMonth(model.getCurrentDatesNep().getMonth()+1),
                model.getCurrentDatesNep().getDay(),
                model.getStringDay(model.getCurrentDatesNep().getDay()));

        view.loadDefaultDateId(model.getCurrentDatesNep().getYear(),
                model.getCurrentDatesNep().getMonth() + 1,
                model.getCurrentDatesNep().getDay());

        view.loadDefaultEvent(model.getEvent(model.getCurrentDatesNep().getYear()
                + "/" + (model.getCurrentDatesNep().getMonth() + 1)
                + "/" + model.getCurrentDatesNep().getDay()));

        view.loadSelectedMonthString(model.getStringMonth(SELECTED_MONTH));

    }

    @Override
    public void rxUnsubscribe() {
    }

    @Override
    public void setView(CalendarContract.View view) {
        this.view = view;
    }

    @Override
    public void getEvent(String date) {
        view.loadDefaultEvent(model.getEvent(date));
    }

    @Override
    public void getSelectedDate(int month, int year) {
        view.getSelectedDate(model.getSelectedDate(month, year));
    }

    @Override
    public void displayListOfEvents(int currentDate, int currentMonth, int currentYear) {
        view.displayListOfEvents(model.getListOfEvents(currentDate, currentMonth, currentYear));
    }

    @Override
    public String getStringNepaliMonth(int i) {
        return model.getStringMonth(i);
    }


}
