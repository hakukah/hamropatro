package com.nextnepal.nextNepalPatro.util.values;

import android.content.Context;
import android.content.SharedPreferences;

public class BaseRepository {

    protected String accessToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        return sharedPreferences.getString("accessToken", "null");
    }

}
