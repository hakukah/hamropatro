package com.nextnepal.nextNepalPatro.activityRadio.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityRadio.model.dto.StreamDto;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StreamAdapter extends RecyclerView.Adapter<StreamAdapter.ViewHolder> {

    private Context context_dco;
    private ArrayList<StreamDto> streamDtoArrayList;

    public StreamAdapter(Context context_dco, ArrayList<StreamDto> streamDtoArrayList) {
        this.context_dco = context_dco;
        this.streamDtoArrayList = streamDtoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_radio, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.RadioName.setText(streamDtoArrayList.get(i).getName());
        viewHolder.RadioSlogan.setText(streamDtoArrayList.get(i).getSlogan());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.radio_id)
        TextView RadioName;

        @BindView(R.id.radio_heading)
        TextView RadioSlogan;

        @BindView(R.id.card_realtiveLayout)
        RelativeLayout relativeLayout;

        /*  StreamDto shoutcast = (StreamDto) parent.getItemAtPosition(position);
        if (shoutcast == null) {

            return;

        }

        textView.setText(shoutcast.getName());

        subPlayer.setVisibility(View.VISIBLE);

        streamURL = shoutcast.getUrl();

        radioManager.playOrPause(streamURL);*/


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
