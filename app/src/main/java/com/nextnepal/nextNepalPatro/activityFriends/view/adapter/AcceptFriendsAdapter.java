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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityFriends.model.FriendRequestAcceptResponse;
import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.activityUsers.service.ApiManager;
import com.nextnepal.nextNepalPatro.util.values.RestURL;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcceptFriendsAdapter extends RecyclerView.Adapter<AcceptFriendsAdapter.ViewHolder> {

    private List<UsersEntity> usersEntityList;
    private Context context;
    private FriendsApiServices friendsApiServices;

    public AcceptFriendsAdapter(List<UsersEntity> usersEntityList, Context context) {
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        Glide.with(context).load(usersEntityList.get(i).getImage()).into(viewHolder.streamerIcon);
        viewHolder.streamerName.setText(usersEntityList.get(i).getFirstName() + " " + usersEntityList.get(i).getLastName());

//        viewHolder.addFriendImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show();
//                FriendsApiServices friendsApiServices = ApiManager.getFriendsApiService();
//                friendsApiServices.acceptFriend(accessToken(context), String.valueOf(usersEntityList.get(i).getId())).enqueue(
//                        new Callback<BaseResponse>() {
//                            @Override
//                            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//                                if (response.isSuccessful())
//                                    Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show();
//                                else {
//                                    Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show();
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<BaseResponse> call, Throwable t) {
//
//                            }
//                        }
//                );
//            }
//        });

        viewHolder.addFriendImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RUNNING", "" + i);
                networkCall(i);

            }
        });


    }


    private void networkCall(int position) {
        friendsApiServices = ApiManager.getClient(RestURL.BASE_URL).create(FriendsApiServices.class);
        Log.d("String alue", "" + usersEntityList.get(position).getId());
        Call<FriendRequestAcceptResponse> categoryCall = friendsApiServices.acceptFriend("Bearer " + accessToken(context), String.valueOf(usersEntityList.get(position).getId()));
        categoryCall.enqueue(new Callback<FriendRequestAcceptResponse>() {
            @Override
            public void onResponse(Call<FriendRequestAcceptResponse> call, Response<FriendRequestAcceptResponse> response) {
                Toast.makeText(context, "AcceptFriends" + response.body().getMsg(), Toast.LENGTH_SHORT).show();

                if (response.isSuccessful())
                    Log.i("RESPONSE", "" + response.body().getMsg());
                else
                    Log.i("ONfailure", "" + response.errorBody());


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
        ImageView addFriendImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
