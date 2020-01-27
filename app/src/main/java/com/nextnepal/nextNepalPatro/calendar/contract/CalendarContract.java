package com.nextnepal.nextNepalPatro.calendar.contract;

import com.nextnepal.nextNepalPatro.calendar.model.dto.EventDto;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroDto;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroEntity;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import java.util.List;

public interface CalendarContract {
    interface View extends BaseView {
        void loadCalendar(List<PatroDto> patroDtoList);

        void loadDefaultEvent(EventDto eventDto);

        void loadDefaultMonth(int selectedYear, String selectedMonth, int day, String stringDay);

        void loadSelectedMonthString(String stringMonth);

        void loadDefaultDateId(int selectedYear, int selectedMonth, int day);

        void getSelectedDate(List<PatroDto> patroDtoList);

        void displayListOfEvents(List<EventDto> eventDtoList);

        String getStringNepaliMonth(int i);
    }

    interface Presenter extends BasePresenter {
        void setView(CalendarContract.View view);

        void getEvent(String date);

        void getSelectedDate(int month, int year);

        void displayListOfEvents(int currentDate, int currentMonth, int currentYear);

        String getStringNepaliMonth(int i);

    }

    interface Model {

        List<PatroDto> getSelectedMonths(int selectedNepaliYear, int selectedNepaliMonth);

        EventDto getEvent(String date);

        PatroEntity getCurrentDatesNep();

        String getStringDay(int i);

        String getStringMonth(int i);

        List<PatroDto> getSelectedDate(int month, int year);

        List<EventDto> getListOfEvents(int currentDate, int currentMonth, int currentYear);

    }
}
