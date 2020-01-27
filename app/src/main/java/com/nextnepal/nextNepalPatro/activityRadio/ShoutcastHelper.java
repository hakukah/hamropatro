package com.nextnepal.nextNepalPatro.activityRadio;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityRadio.model.dto.StreamDto;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class ShoutcastHelper {

    public static ArrayList<StreamDto> retrieveShoutcasts(Context context){

        Reader reader = new InputStreamReader(context.getResources().openRawResource(R.raw.shoutcasts));

        return (new Gson()).fromJson(reader, new TypeToken<List<StreamDto>>() {}.getType());
    }

}
