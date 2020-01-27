package com.nextnepal.nextNepalPatro.myCard.view.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.nextnepal.nextNepalPatro.activityCardDetails.view.CardDetailsActivity;
import com.nextnepal.nextNepalPatro.myCard.contract.CardSelection;
import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.nextnepal.nextNepalPatro.myCard.view.MyCardFragment.designation_V;
import static com.nextnepal.nextNepalPatro.myCard.view.MyCardFragment.organization_V;
import static com.nextnepal.nextNepalPatro.myCard.view.MyCardFragment.phone_V;

public class CardSelectionAdapter extends RecyclerView.Adapter<CardSelectionAdapter.ViewHolder> {

    private Context context_dco;
    private List<CardSelectionEntity> cardSelectionEntityArrayList;
    private CardSelection cardSelection;

    public CardSelectionAdapter(Context context_dco, List<CardSelectionEntity> cardSelectionEntityArrayList, CardSelection cardSelection) {
        this.context_dco = context_dco;
        this.cardSelectionEntityArrayList = cardSelectionEntityArrayList;
        this.cardSelection = cardSelection;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context_dco).inflate(R.layout.card_card_selection, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Glide.with(context_dco).load(cardSelectionEntityArrayList.get(i).getTemplate()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    viewHolder.cardImageView_v.setBackground(resource);
                }
            }
        });
        viewHolder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CONST.DEFAULT_CARD_ID = cardSelectionEntityArrayList.get(i).getId();
                cardSelection.loadFriendList();
            }
        });
        viewHolder.phone_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + viewHolder.phone_v.getText().toString()));
                context_dco.startActivity(intent);
            }
        });
        viewHolder.cardImageView_v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(context_dco.getApplicationContext(), CardDetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context_dco.startActivity(intent);
                return false;
            }
        });
        viewHolder.facebook_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        viewHolder.linkden_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        viewHolder.google_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        viewHolder.designation_v.setText(designation_V);
        viewHolder.company_v.setText(organization_V);
        viewHolder.phone_v.setText(phone_V);
    }

    @Override
    public int getItemCount() {
        return cardSelectionEntityArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.check_card)
        RadioButton radioButton;

        @BindView(R.id.card_background)
        RelativeLayout cardImageView_v;

        @BindView(R.id.phone)
        TextView phone_v;

        @BindView(R.id.name)
        TextView name_v;

        @BindView(R.id.company)
        TextView company_v;

        @BindView(R.id.designation)
        TextView designation_v;

        @BindView(R.id.facebook)
        ImageView facebook_v;

        @BindView(R.id.linkden)
        ImageView linkden_v;

        @BindView(R.id.google)
        ImageView google_v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            if (retrieveCache() != null) {
                name_v.setText(retrieveCache().getFirstName() + " " + retrieveCache().getLastName());
                //            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) designation_v.getLayoutParams();
//            params.addRule(RelativeLayout.ALIGN_PARENT_);
//            // params.addRule(RelativeLayout.LEFT_OF, R.id.id_to_be_left_of);
//            designation_v.setLayoutParams(params)
            } else {

            }
        }

    }

    private ProfileDto retrieveCache() {
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context_dco.getSharedPreferences("profile", Context.MODE_PRIVATE);
        String json = sharedPreferences.getString("profile", "");
        ProfileDto profileDto = gson.fromJson(json, ProfileDto.class);
        return profileDto;
    }


}
