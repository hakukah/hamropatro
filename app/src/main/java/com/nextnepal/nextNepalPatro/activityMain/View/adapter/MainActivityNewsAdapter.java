package com.nextnepal.nextNepalPatro.activityMain.View.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nextnepal.nextNepalPatro.activityMain.model.dto.HeadlinesDto;
import com.nextnepal.nextNepalPatro.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityNewsAdapter extends RecyclerView.Adapter<MainActivityNewsAdapter.ViewHolder> {
    private ArrayList<HeadlinesDto> headlinesDtoArrayList;
    private Context dco_context;

    public MainActivityNewsAdapter(ArrayList<HeadlinesDto> headlinesDtoArrayList, Context dco_context) {
        this.headlinesDtoArrayList = headlinesDtoArrayList;
        this.dco_context = dco_context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(dco_context).inflate(R.layout.card_main_activity_news, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.headline.setText(headlinesDtoArrayList.get(i).getNewsTitle());
        viewHolder.news_icon.setImageBitmap(headlinesDtoArrayList.get(i).getNewsIcon());
    }

    @Override
    public int getItemCount() {
        return headlinesDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.news_headline)
        TextView headline;

        @BindView(R.id.news_image)
        ImageView news_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
