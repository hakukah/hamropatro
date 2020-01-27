package com.nextnepal.nextNepalPatro.util.values;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("error")
    private boolean error;

    public String getMessage() {
        return success;
    }

    public void setMessage(String message) {
        this.success = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
