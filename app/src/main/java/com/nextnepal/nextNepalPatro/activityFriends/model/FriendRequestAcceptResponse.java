package com.nextnepal.nextNepalPatro.activityFriends.model;

import com.google.gson.annotations.SerializedName;

public class FriendRequestAcceptResponse {
    @SerializedName("msg")
    String msg;
    @SerializedName("error")
    Boolean error;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}

