package com.nextnepal.nextNepalPatro.activityFriends.model.dto;

import java.util.List;

public  class FriendsListEntity {

    private boolean error;
    private List<FriendListDataDto> data;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<FriendListDataDto> getData() {
        return data;
    }

    public void setData(List<FriendListDataDto> data) {
        this.data = data;
    }
}
