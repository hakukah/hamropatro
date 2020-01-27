package com.nextnepal.nextNepalPatro.activityFriends.view.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityCardSharing.service.CardSharingApiService;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendListDataDto;
import com.nextnepal.nextNepalPatro.activityUsers.service.ApiManager;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.ViewHolder> {

    private List<FriendListDataDto> usersEntityList;
    private Context context;
    private CardSharingApiService cardSharingApiService;

    public FriendsListAdapter(List<FriendListDataDto> usersEntityList, Context context) {
        this.usersEntityList = usersEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_friends, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.streamerName.setText((usersEntityList.get(i).getFirstName() + " " + usersEntityList.get(i).getLastName()));
        Glide.with(context).load(usersEntityList.get(i).getImage()).into(viewHolder.imageView);
        viewHolder.email.setText(usersEntityList.get(i).getEmail());
        viewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                networkCall(i, view);
            }
        });
    }


    @Override
    public int getItemCount() {
        return usersEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.icon_name)
        TextView streamerName;

        @BindView(R.id.relative_live)
        RelativeLayout liveRelative_v;

        @BindView(R.id.icon)
        CircleImageView imageView;

        @BindView(R.id.email)
        TextView email;

        @BindView(R.id.share)
        ImageView share;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void networkCall(int position, final View view) {

        cardSharingApiService = ApiManager.getClient(RestURL.BASE_URL).create(CardSharingApiService.class);
        Call<BaseResponse> categoryCall = cardSharingApiService.shareCard("Bearer " + accessToken(context), String.valueOf(usersEntityList.get(position).getId()), String.valueOf(CONST.DEFAULT_CARD_ID));
        categoryCall.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("RESPONSE", "" + response.body().getMessage());
                    view.setVisibility(View.GONE);
                } else {
                    Log.i("ONfailure", "" + response.errorBody());
                    view.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.i("onFailure", "" + t.getMessage());

            }
        });
    }

    protected String accessToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        return sharedPreferences.getString("accessToken", "null");
    }
}
