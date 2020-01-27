package com.nextnepal.nextNepalPatro.calendar.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.calendar.model.dto.EventDto;

import java.util.List;

public class WeeklyRecyclerAdapter extends RecyclerView.Adapter<WeeklyRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<EventDto> eventDtos;

    public WeeklyRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.weekly_event_views, viewGroup, false);
        return new WeeklyRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textEvent.setText(String.valueOf(eventDtos.get(viewHolder.getAdapterPosition()).getEventId()));
        viewHolder.englishEvent.setText(eventDtos.get(viewHolder.getAdapterPosition()).getTithe());
        viewHolder.nepaliEvent.setText(eventDtos.get(viewHolder.getAdapterPosition()).getEventDetailNp());
        viewHolder.nepaliThithi.setText(eventDtos.get(viewHolder.getAdapterPosition()).getEventDetailEn());
    }

    @Override
    public int getItemCount() {
        if (eventDtos == null) {
            return 0;
        } else {
            return eventDtos.size();
        }
    }

    public void setWeeklyEvent(List<EventDto> eventDtoList) {
        this.eventDtos = eventDtoList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textEvent, englishEvent, nepaliEvent, nepaliThithi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            englishEvent = itemView.findViewById(R.id.englishEvent);
            textEvent = itemView.findViewById(R.id.date);
            nepaliEvent = itemView.findViewById(R.id.nepaliEvent);
            nepaliThithi = itemView.findViewById(R.id.nepaliThithi);
        }
    }
}
