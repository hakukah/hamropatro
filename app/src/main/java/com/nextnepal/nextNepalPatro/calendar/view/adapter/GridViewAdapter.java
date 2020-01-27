package com.nextnepal.nextNepalPatro.calendar.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroDto;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private Context activty;
    private List<PatroDto> listOfDaysInMonth;
    private String id = "";

    public GridViewAdapter(Context calendarActivity) {
        this.activty = calendarActivity;
    }

    @Override
    public int getCount() {

        if (listOfDaysInMonth == null) {
            return 0;
        } else {
            return listOfDaysInMonth.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) activty.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_calendar_day, parent, false);
        TextView dateMajor = convertView.findViewById(R.id.major);
        TextView dateMinor = convertView.findViewById(R.id.minor);
        if (listOfDaysInMonth.get(position).getId() != null) {
            dateMinor.setText(String.valueOf(listOfDaysInMonth.get(position).getSelectedEnglishDay()));
            dateMajor.setText(String.valueOf(listOfDaysInMonth.get(position).getSelectedNepaliDay()));
        }
        if (id.equals(listOfDaysInMonth.get(position).getId())) {
            ConstraintLayout constraintLayout = convertView.findViewById(R.id.constraint_parent);
            constraintLayout.setBackgroundColor(activty.getResources().getColor(R.color.grey500));
            dateMajor.setTextColor(activty.getResources().getColor(R.color.white));
            dateMinor.setTextColor(activty.getResources().getColor(R.color.white));
        }
//
        if (listOfDaysInMonth.get(position).getIsHoliday() == 0 || listOfDaysInMonth.get(position).getDayOfWeek() == 7) {
            dateMajor.setTextColor(activty.getResources().getColor(R.color.reda700));
            dateMinor.setTextColor(activty.getResources().getColor(R.color.reda700));
        }
        return convertView;
    }

    public void setDays(List<PatroDto> listOfDaysInMonth, String id) {
        this.listOfDaysInMonth = listOfDaysInMonth;
        this.id = id;
//        Toast.makeText(activty, "Adapter id::" + id, Toast.LENGTH_LONG).show();
        notifyDataSetChanged();
    }


//    public void setCurrentDay(String id) {
//        this.id = id;
//        Log.d("VALUE:", "Value Of Id" + id);
//        notifyDataSetChanged();
//    }
}
