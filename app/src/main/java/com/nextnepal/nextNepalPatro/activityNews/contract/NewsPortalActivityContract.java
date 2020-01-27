package com.nextnepal.nextNepalPatro.activityNews.contract;

import com.nextnepal.nextNepalPatro.activityNews.model.dto.NewsPortalDto;

import java.util.ArrayList;

public interface NewsPortalActivityContract {

    interface View {
        void initView();

        void loadNewsPortal(ArrayList<NewsPortalDto> newsPortalDtoArrayList);

        void showMessage(String Message);

    }

    interface Model {
        ArrayList<NewsPortalDto> loadNewsPortal();
    }

    interface Presenter {
        void setView(NewsPortalActivityContract.View view);
    }
}
