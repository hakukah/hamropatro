package com.nextnepal.nextNepalPatro.activityNews.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.DataEntity;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.Data;
import com.nextnepal.nextNepalPatro.activityNews.view.NewsExploreActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Data> newsDtoList;
    private Context context_dco;

    public NewsAdapter(List<Data> newsDtoList, Context context_dco) {
        this.newsDtoList = newsDtoList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_main_activity_news, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.newsPaperId_v.setText(newsDtoList.get(i).getMedia());
        viewHolder.newsHeadlines_v.setText(newsDtoList.get(i).getTitle());
        viewHolder.publishDate_v.setText(newsDtoList.get(i).getPubDate());
        Glide.with(context_dco).load(newsDtoList.get(i).getUrl()).into(viewHolder.newsPaperIcon);
        if (newsDtoList.get(i).getThumbnail() != null) {
            viewHolder.thumbnail_v.setVisibility(View.VISIBLE);
            Glide.with(context_dco).load(newsDtoList.get(i).getThumbnail()).into(viewHolder.thumbnail_v);
        }
        final String url = newsDtoList.get(i).getLink();
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context_dco, NewsExploreActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("url", url);
                context_dco.startActivity(intent);
            }
        });
//        viewHolder.newsPaperId_v.setText(newsDtoList.get(i).getTitle());
//        Glide.with(context_dco).load(newsDtoList.get(i).getImage().getUrl()).into(viewHolder.newsPaperIcon);
//        viewHolder.newsHeadlines_v.setText(newsDtoList.get(i).getItem().get(i).getTitle());
//        final String url = newsDtoList.get(i).getItem().get(i).getLink();
//        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context_dco, NewsExploreActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("url", url);
//                context_dco.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() throws NullPointerException {
        Log.i("news size", "" + newsDtoList.size());
        if (newsDtoList == null) {
            return 0;
        }
        return newsDtoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.relative)
        ConstraintLayout relativeLayout;

        @BindView(R.id.newsPaper_id)
        TextView newsPaperId_v;

        @BindView(R.id.news_headline)
        TextView newsHeadlines_v;

        @BindView(R.id.news_image)
        ImageView newsPaperIcon;

        @BindView(R.id.publish_date)
        TextView publishDate_v;

        @BindView(R.id.thumnail)
        ImageView thumbnail_v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
