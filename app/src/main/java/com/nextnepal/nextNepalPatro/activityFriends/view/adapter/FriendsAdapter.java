package com.nextnepal.nextNepalPatro.activityFriends.view.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.activityUsers.service.ApiManager;
import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.ViewHolder> {

    private List<UsersEntity> usersEntityList;
    private Context context;


    public FriendsAdapter(List<UsersEntity> usersEntityList, Context context) {
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
        viewHolder.addFriendImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersApiService usersApiService = ApiManager.getAPIService();
                usersApiService.sentFriendRequest(accessToken(context), String.valueOf(usersEntityList.get(i).getId())).enqueue(
                        new Callback<BaseResponse>() {
                            @Override
                            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                                if (response.isSuccessful())
                                    Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show();
                                else {
                                    Toast.makeText(context, response.message(), Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<BaseResponse> call, Throwable t) {

                            }
                        }
                );
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