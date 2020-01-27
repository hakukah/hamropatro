package com.nextnepal.nextNepalPatro.activityMain.contract;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityMain.model.dto.HeadlinesDto;
import com.nextnepal.nextNepalPatro.activityMain.model.dto.MenuDto;
import com.nextnepal.nextNepalPatro.util.mvp.presenter.BasePresenter;

import java.util.ArrayList;

public interface MainActivityContract {

    interface View {
        void checkLogged(boolean loggedState);
    }

    interface Model {
        boolean checkLogged(Context context);
    }

    interface Presenter extends BasePresenter {

        void checkLogged(Context context);

        void setView(MainActivityContract.View view);

        boolean checkIfLogged(Context context);

    }
}
