package com.nextnepal.nextNepalPatro.activityFriends.view.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityFriends.model.FriendRequestAcceptResponse;
import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.activityUsers.service.ApiManager;
import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendFriendsRequestAdapter extends RecyclerView.Adapter<SendFriendsRequestAdapter.ViewHolder> {

    private List<UsersEntity> usersEntityList;
    private Context context;
    private FriendsApiServices friendsApiServices;


    public SendFriendsRequestAdapter(List<UsersEntity> usersEntityList, Context context) {
        this.usersEntityList = usersEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_userlist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Glide.with(context).load(usersEntityList.get(i).getImage()).into(viewHolder.streamerIcon);
        viewHolder.streamerName.setText(usersEntityList.get(i).getFirstName() + " " + usersEntityList.get(i).getLastName());
        viewHolder.addFriendImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                networkCall(i, v);

            }
        });
    }

    private void networkCall(int position, final View view) {
        friendsApiServices = ApiManager.getClient(RestURL.BASE_URL).create(FriendsApiServices.class);
        Log.d("String alue", "" + usersEntityList.get(position).getId());
        Call<FriendRequestAcceptResponse> categoryCall = friendsApiServices.acceptFriend("Bearer " + accessToken(context), String.valueOf(usersEntityList.get(position).getId()));
        categoryCall.enqueue(new Callback<FriendRequestAcceptResponse>() {
            @Override
            public void onResponse(Call<FriendRequestAcceptResponse> call, Response<FriendRequestAcceptResponse> response) {
                Toast.makeText(context, "AcceptFriends" + response.body().getMsg(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    Log.i("RESPONSE", "" + response.body().getMsg());
                    view.setVisibility(View.GONE);

                } else {
                    Log.i("ONfailure", "" + response.errorBody());
                    view.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<FriendRequestAcceptResponse> call, Throwable t) {
                Log.i("onFailer", "" + t.getMessage());

            }
        });


    }


    private String accessToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        return sharedPreferences.getString("accessToken", "null");
    }

    @Override
    public int getItemCount() {
        return usersEntityList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon)
        ImageView streamerIcon;

        @BindView(R.id.icon_name)
        TextView streamerName;

        @BindView(R.id.relative_live)
        RelativeLayout liveRelative_v;

        @BindView(R.id.addIcon)
        Button addFriendImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
