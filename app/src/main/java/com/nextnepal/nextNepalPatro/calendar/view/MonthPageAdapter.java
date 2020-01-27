package com.nextnepal.nextNepalPatro.calendar.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MonthPageAdapter extends FragmentPagerAdapter {
    private CalendarPatroFragment[] fragList;

    MonthPageAdapter(FragmentManager fm, CalendarPatroFragment[] fragList) {
        super(fm);
        this.fragList = fragList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragList[i];
    }

    @Override
    public int getCount() {
        return 3;
    }


}