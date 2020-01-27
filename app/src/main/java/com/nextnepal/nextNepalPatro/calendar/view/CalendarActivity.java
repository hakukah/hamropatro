package com.nextnepal.nextNepalPatro.calendar.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.calendar.contract.CalendarContract;
import com.nextnepal.nextNepalPatro.calendar.contract.LoadEvent;
import com.nextnepal.nextNepalPatro.calendar.model.dto.EventDto;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroDto;
import com.nextnepal.nextNepalPatro.calendar.view.adapter.WeeklyRecyclerAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.nextnepal.nextNepalPatro.calendar.view.CalendarPatroFragment.date;
import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.SELECTED_MONTH;
import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.SELECTED_YEAR;

public class CalendarActivity extends AppCompatActivity implements CalendarContract.View, LoadEvent {

    static int mPageLastScreen = 0;
    @Inject
    CalendarContract.Presenter presenter;
    @BindView(R.id.major_event)
    TextView nepaliEvent_v;
    @BindView(R.id.minor_event)
    TextView englishEvent_v;
    @BindView(R.id.major_tithi)
    TextView tithi;
    @BindView(R.id.month_text)
    TextView month_text;
    @BindView(R.id.major_n_year)
    TextView major_n_year;
    @BindView(R.id.weeklyEvent)
    RecyclerView weeklyEventRecycler;
    @BindView(R.id.year_text)
    TextView year_text;
    CalendarPatroFragment[] fragList = new CalendarPatroFragment[3];
    private List<PatroDto> patroDtoList;
    private List<EventDto> eventDtoList;
    private String id;

    @Override
    public void onStart() {
        super.onStart();
    }

    public void notifyDataSetChanged() {
        presenter.getEvent(date);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);
        presenter.setView(this);
        fragList[0] = new CalendarPatroFragment(this, id);
        fragList[1] = new CalendarPatroFragment(this, id);
        fragList[2] = new CalendarPatroFragment(this, id);
        ViewPager viewPager = findViewById(R.id.calenderViewPager);

        MonthPageAdapter monthPageAdapter = new MonthPageAdapter(getSupportFragmentManager(), fragList);

        viewPager.setAdapter(monthPageAdapter);
        updateFragments();
        viewPager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float v, int i1) {
                        fragList[position].update(id);
                    }

                    @Override
                    public void onPageSelected(int position) {
                        mPageLastScreen = position;
                    }

                    @Override
                    public void onPageScrollStateChanged(int i) {
                        if (i == ViewPager.SCROLL_STATE_IDLE) {
                            if (mPageLastScreen > 1) {
                                increaseMonth();
                            } else if (mPageLastScreen < 1) {
                                decreaseMonth();
                            }
                            updateFragments();
                        }
                    }
                });
        viewPager.setCurrentItem(1, false);
        presenter.displayListOfEvents(1, 9, 2076);
        WeeklyRecyclerAdapter weeklyReyclerAdapter = new WeeklyRecyclerAdapter(this);
        weeklyEventRecycler.setAdapter(weeklyReyclerAdapter);
        weeklyEventRecycler.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        weeklyEventRecycler.setLayoutManager(layoutManager4);
        weeklyReyclerAdapter.setWeeklyEvent(eventDtoList);
    }

    private void updateFragments() {
        presenter.loadData();
        List<PatroDto> currentPatroDtoList = patroDtoList;
        fragList[1].setNewData(currentPatroDtoList);
        increaseMonth();
        presenter.loadData();
        List<PatroDto> nextPatroDtoList = patroDtoList;
        fragList[2].setNewData(nextPatroDtoList);
        decreaseMonth();
        decreaseMonth();
        presenter.loadData();
        List<PatroDto> previousPatroDtoList = patroDtoList;
        fragList[0].setNewData(previousPatroDtoList);
        increaseMonth();
    }

    @Override
    public void displayListOfEvents(List<EventDto> eventDtoList) {
        this.eventDtoList = eventDtoList;
    }

    @Override
    public String getStringNepaliMonth(int i) {
        return presenter.getStringNepaliMonth(i);
    }

    private void decreaseMonth() {
        if (SELECTED_MONTH != 1) {
            SELECTED_MONTH = SELECTED_MONTH - 1;
        } else {
            SELECTED_MONTH = 12;
            SELECTED_YEAR = SELECTED_YEAR - 1;
        }
        year_text.setText(String.valueOf(SELECTED_YEAR));
        month_text.setText(getStringNepaliMonth(SELECTED_MONTH + 1));
    }

    private void increaseMonth() {
        if (SELECTED_MONTH != 12) {
            SELECTED_MONTH = SELECTED_MONTH + 1;
        } else {
            SELECTED_MONTH = 1;
            SELECTED_YEAR = SELECTED_YEAR + 1;
        }
        year_text.setText(String.valueOf(SELECTED_YEAR));
        //    month_text.setText(String.valueOf(SELECTED_MONTH + 1));
        month_text.setText(getStringNepaliMonth(SELECTED_MONTH + 1));

    }

    @Override
    public void loadCalendar(final List<PatroDto> patroDtoList) {
        this.patroDtoList = patroDtoList;
    }

    @Override
    public void loadDefaultEvent(EventDto eventDto) {
        if (eventDto != null) {
            nepaliEvent_v.setText(eventDto.getEventDetailNp());
            englishEvent_v.setText(eventDto.getEventDetailEn());
            tithi.setText(eventDto.getTithe());
        }
    }

    @Override
    public void loadDefaultMonth(int selectedYear, String selectedMonth, int day, String stringDay) {
        month_text.setText(String.valueOf(selectedMonth));
        year_text.setText(String.valueOf(selectedYear));
        id = selectedYear + "/" + selectedMonth + "/" + day;
//        Toast.makeText(getApplicationContext(), "activity id::" + id, Toast.LENGTH_LONG).show();
    }


    @Override
    public void loadSelectedMonthString(String stringMonth) {
        month_text.setText(stringMonth);
    }

    @Override
    public void loadDefaultDateId(int selectedYear, int selectedMonth, int day) {


    }

    @Override
    public void getSelectedDate(List<PatroDto> patroDtoList) {

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


}
