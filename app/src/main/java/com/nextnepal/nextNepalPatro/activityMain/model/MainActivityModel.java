package com.nextnepal.nextNepalPatro.activityMain.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;

import com.nextnepal.nextNepalPatro.activityMain.contract.MainActivityContract;
import com.nextnepal.nextNepalPatro.activityMain.model.dto.HeadlinesDto;
import com.nextnepal.nextNepalPatro.activityMain.model.dto.MenuDto;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;

import java.util.ArrayList;

public class MainActivityModel extends BaseRepository implements MainActivityContract.Model {

    @Override
    public boolean checkLogged(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("loggedIn", false);
    }
}
