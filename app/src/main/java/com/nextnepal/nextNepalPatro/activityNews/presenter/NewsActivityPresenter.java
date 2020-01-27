package com.nextnepal.nextNepalPatro.activityNews.presenter;


import com.nextnepal.nextNepalPatro.activityNews.contract.NewsPortalActivityContract;
import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

public class NewsActivityPresenter<V extends BaseView> implements NewsPortalActivityContract.Presenter {
    private NewsPortalActivityContract.View View_ic;
    private NewsPortalActivityContract.Model Model_ic;


    @Override
    public void setView(NewsPortalActivityContract.View View_ic) {
        this.View_ic = View_ic;
        View_ic.initView();
        View_ic.loadNewsPortal(Model_ic.loadNewsPortal());
    }

    public NewsActivityPresenter(NewsPortalActivityContract.Model Model_ic) {
        this.Model_ic = Model_ic;
    }
}
