package com.nextnepal.nextNepalPatro.activityMain.View.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nextnepal.nextNepalPatro.activityMain.model.dto.MenuDto;
import com.nextnepal.nextNepalPatro.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityMenuAdapter extends RecyclerView.Adapter<MainActivityMenuAdapter.ViewHolder> {
    private Context dco_context;
    private List<MenuDto> menuDtoArrayList;

    public MainActivityMenuAdapter(Context dco_context, List<MenuDto> menuDtoArrayList) {
        this.dco_context = dco_context;
        this.menuDtoArrayList = menuDtoArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(dco_context).inflate(R.layout.card_main_activity_menu, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(menuDtoArrayList.get(i).getName());
        viewHolder.icon.setImageBitmap(menuDtoArrayList.get(i).getIcon());
    }

    @Override
    public int getItemCount() {
        return menuDtoArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.icon_menu)
        ImageView icon;

        @BindView(R.id.icon_name)
        TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
