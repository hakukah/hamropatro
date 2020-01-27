package com.nextnepal.nextNepalPatro.activityLiveStream.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityYoutube.YoutubeActivity;
import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamDataDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveStreamAdapter extends RecyclerView.Adapter<LiveStreamAdapter.ViewHolder> {

    private List<LiveStreamDataDto> liveStreamEntityList;
    private Context context;

    public LiveStreamAdapter(List<LiveStreamDataDto> liveStreamEntityList, Context context) {
        this.liveStreamEntityList = liveStreamEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_livestream, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Glide.with(context).load(liveStreamEntityList.get(i).getThumbnail()).into(viewHolder.streamerIcon);
        viewHolder.streamerName.setText(liveStreamEntityList.get(i).getTitle());
        final String url = liveStreamEntityList.get(i).getVideoId();
        viewHolder.liveRelative_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), YoutubeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("url", liveStreamEntityList.get(i).getVideoId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return liveStreamEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon)
        ImageView streamerIcon;

        @BindView(R.id.icon_name)
        TextView streamerName;

        @BindView(R.id.relative_live)
        RelativeLayout liveRelative_v;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
