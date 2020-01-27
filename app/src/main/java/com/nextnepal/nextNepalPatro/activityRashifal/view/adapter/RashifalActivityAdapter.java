package com.nextnepal.nextNepalPatro.activityRashifal.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalDto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class RashifalActivityAdapter extends RecyclerView.Adapter<RashifalActivityAdapter.ViewHolder> {

    private Context dco_context;

    private List<RashifalDto> rashifalDtoArrayList;


    public RashifalActivityAdapter(List<RashifalDto> rashifalDtoArrayList, Context dco_context) {
        this.rashifalDtoArrayList = rashifalDtoArrayList;
        this.dco_context = dco_context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(dco_context).inflate(R.layout.card_rasifal_activity, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.rashifalBody.setText(rashifalDtoArrayList.get(i).getRashi());
        viewHolder.rashifalName.setText(rashifalDtoArrayList.get(i).getName());
        Glide.with(dco_context).load(rashifalDtoArrayList.get(i).getImage()).into(viewHolder.circleImageView);
    }

    @Override
    public int getItemCount() {
        return rashifalDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rashi_name)
        TextView rashifalName;

        @BindView(R.id.rashi_body)
        TextView rashifalBody;

        @BindView(R.id.rashi_image)
        CircleImageView circleImageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
