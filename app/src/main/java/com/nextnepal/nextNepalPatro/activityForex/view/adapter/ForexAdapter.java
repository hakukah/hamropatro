package com.nextnepal.nextNepalPatro.activityForex.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForexAdapter extends RecyclerView.Adapter<ForexAdapter.ViewHolder> {
    private List<ForexEntity> forexEntityArrayList;
    private Context context_dco;

    public ForexAdapter(List<ForexEntity> forexEntityArrayList, Context context_dco) {
        this.forexEntityArrayList = forexEntityArrayList;
        this.context_dco = context_dco;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_forex, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.countryName_v.setText(forexEntityArrayList.get(i).getCurrency());
        viewHolder.buyingRate_v.setText(forexEntityArrayList.get(i).getBuying());
        viewHolder.sellingRate_v.setText(forexEntityArrayList.get(i).getSelling());
        Glide.with(context_dco).load(forexEntityArrayList.get(i).getImage()).into(viewHolder.countryFlag_v);
    }

    @Override
    public int getItemCount() {
        return forexEntityArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview_flag)
        ImageView countryFlag_v;

        @BindView(R.id.textview_countryName)
        TextView countryName_v;

        @BindView(R.id.textView_buying)
        TextView buyingRate_v;

        @BindView(R.id.textView_selling)
        TextView sellingRate_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
