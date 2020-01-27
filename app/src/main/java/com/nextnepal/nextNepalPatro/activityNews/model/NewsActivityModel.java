package com.nextnepal.nextNepalPatro.activityNews.model;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

import com.nextnepal.nextNepalPatro.activityNews.contract.NewsPortalActivityContract;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.BBC.ArticlesDto;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.BBC.BBCDto;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsPortalDto;
import com.nextnepal.nextNepalPatro.R;

import java.util.ArrayList;
import java.util.List;

public class NewsActivityModel implements NewsPortalActivityContract.Model {

    private ArrayList<NewsPortalDto> newsPortalDtoArrayList;
    private NewsPortalDto newsPortalDto;
    private ArrayList<BBCDto> bbcDtoArrayList;


    List<ArticlesDto> articlesDtoList;

    ArrayList<ArticlesDto> articlesDtoArrayListt;


    @Override
    public ArrayList<NewsPortalDto> loadNewsPortal() {
        newsPortalDtoArrayList = new ArrayList<>();
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);
        newsPortalDto = new NewsPortalDto(1, "Hello", BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher_round));
        newsPortalDtoArrayList.add(newsPortalDto);

        return newsPortalDtoArrayList;

//        bbcDtoArrayList = new ArrayList<>();
//        Call<BBCDto> call = bbcApiService_ii.getBBCHeadlines(Source,BBC_API_KEY);
//        call.enqueue(new Callback<BBCDto>() {
//            @Override
//            public void onResponse(Call<BBCDto> call, Response<BBCDto> response) {
//                List<ArticlesDto> bbcDtoList = Arrays.asList(response.body().getArticles());
//                for (ArticlesDto top : bbcDtoList) {
//                    Log.i("name", top.getAuthor());
//                }
//            }
//            @Override
//            public void onFailure(Call<BBCDto> call, Throwable t) {
//
//            }
//        });
//        return bbcDtoArrayList;


    }
}
