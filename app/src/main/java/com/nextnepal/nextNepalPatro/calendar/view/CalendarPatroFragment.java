package com.nextnepal.nextNepalPatro.calendar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.calendar.contract.CalendarContract;
import com.nextnepal.nextNepalPatro.calendar.contract.LoadEvent;
import com.nextnepal.nextNepalPatro.calendar.model.dto.EventDto;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroDto;
import com.nextnepal.nextNepalPatro.calendar.view.adapter.GridViewAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.CURRENT_DAY;

@SuppressLint("ValidFragment")
public class CalendarPatroFragment extends Fragment implements CalendarContract.View, LoadEvent {
    public static String date;
    public CalendarActivity calendarActivity;
    @Inject
    CalendarContract.Presenter presenter;
    private GridViewAdapter gridViewAdapter;
    private MyGridView myGridView;
    private List<PatroDto> patroDtoLists;
    private ArrayList<Integer> tempholidayarry, listofholiday;
    private ArrayList<PatroDto> temparray;
    private int starting_day_gap;
    private String id;

    public CalendarPatroFragment(CalendarActivity calendarActivity, String id) {
        this.calendarActivity = calendarActivity;
//        this.id = id;
    }

    public void setNewData(List<PatroDto> patroDtoList) {
        this.patroDtoLists = patroDtoList;
    }

    public void update(String id) {
        View v = getView();
        if (v == null) {
            return;
        }
        if (patroDtoLists.size() >= 1) {
            temparray = new ArrayList<>();
            tempholidayarry = new ArrayList<>();
            starting_day_gap = patroDtoLists.get(0).getDayOfWeek();
            for (int i = 1; i < starting_day_gap; i++) {
                PatroDto patrotemp = new PatroDto(0, 0, 0, 0, 0, 0, null, 0, 0);
                temparray.add(patrotemp);
            }
            temparray.addAll(patroDtoLists);
            gridViewAdapter.setDays(temparray, this.id);
//            gridViewAdapter.setCurrentDay(id);
//            gridViewAdapter.

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar_patro, container, false);
        myGridView = view.findViewById(R.id.gridView_calendar2);
        gridViewAdapter = new GridViewAdapter(getContext());
        myGridView.setAdapter(gridViewAdapter);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                date = temparray.get(position).getSelectedNepaliYear()
                        + "/" + temparray.get(position).getSelectedNepaliMonth()
                        + "/" + temparray.get(position).getSelectedNepaliDay();
                presenter.getEvent(date);
                calendarActivity.notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void loadCalendar(List<PatroDto> patroDtoList) {
        if (patroDtoList.size() >= 1) {
            temparray = new ArrayList<>();
            tempholidayarry = new ArrayList<>();
            starting_day_gap = patroDtoList.get(0).getDayOfWeek();
            for (int i = 1; i < starting_day_gap; i++) {
                PatroDto patrotemp = new PatroDto(0, 0, 0, 0, 0, 0, null, 0, 0);
                temparray.add(patrotemp);
            }
            temparray.addAll(patroDtoList);
            gridViewAdapter.setDays(temparray, id);

        }
    }

    @Override
    public void loadDefaultEvent(EventDto eventDto) {


    }

    @Override
    public void loadDefaultMonth(int selectedYear, String selectedMonth, int day, String stringDay) {
    }

    @Override
    public void loadSelectedMonthString(String stringMonth) {

    }

    @Override
    public void loadDefaultDateId(int selectedYear, int selectedMonth, int day) {
        //  Log.d("TEST SELECTED LOAD DEFAULT DATE ID ", "RUNNING");

        id = selectedYear + "/" + selectedMonth + "/" + CURRENT_DAY;


    }

    @Override
    public void getSelectedDate(List<PatroDto> patroDtoList) {
        if (patroDtoList != null)
            Log.d("SELECTED MONTH SIZE ", "" + patroDtoList.size());

    }

    @Override
    public void displayListOfEvents(List<EventDto> eventDtoList) {

    }

    /**
     * to display nepali month on the top of calendar
     */
    @Override
    public String getStringNepaliMonth(int i) {
     return presenter.getStringNepaliMonth(i);
    }


    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void showLoading(boolean isLoading) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSucess() {

    }

    @Override
    public void loadEvent(EventDto eventDto) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadDefaultDateId(2076, 7, 1);
    }
}
