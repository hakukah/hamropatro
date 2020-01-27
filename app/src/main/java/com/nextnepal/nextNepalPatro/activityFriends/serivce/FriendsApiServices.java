package com.nextnepal.nextNepalPatro.activityFriends.serivce;

import com.nextnepal.nextNepalPatro.activityFriends.model.FriendRequestAcceptResponse;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendsListEntity;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.values.BaseResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface FriendsApiServices {
    @GET("friend-request-list")
    Observable<List<UsersEntity>> getFriendsRequest(@Header("Authorization") String auth);

    @GET("friends")
    Observable<FriendsListEntity> getFriends(@Header("Authorization") String auth);

    @GET("accept-friend-request/{id}")
    Call<FriendRequestAcceptResponse> acceptFriend(@Header("Authorization") String auth, @Path("id") String id);
}
