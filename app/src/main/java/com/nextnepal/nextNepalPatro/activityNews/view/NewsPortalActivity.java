package com.nextnepal.nextNepalPatro.activityNews.view;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.activityNews.contract.NewsContract;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.DataEntity;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.Data;
import com.nextnepal.nextNepalPatro.activityNews.view.adapter.NewsAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsPortalActivity extends AppCompatActivity implements NewsContract.View {

    @BindView(R.id.recycler_news_portal)
    RecyclerView v_recyclerViewNewsPortal;

    @Inject
    NewsContract.Presenter presenter;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefreshLayout_v;

    List<Data> newsDtoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_portal);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        swipeRefreshLayout_v.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadData();
                swipeRefreshLayout_v.setRefreshing(false);
            }
        });
    }

    @Override
    public void initView() {
        Log.i("Init View", "Init View");
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(v_recyclerViewNewsPortal, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(boolean isLoading) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSucess() {

    }


    @Override
    public void updateData(List<Data> newsDtoList) {
        Log.i("news Dto List", "Checked::" + newsDtoList.size());
        this.newsDtoList = newsDtoList;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        v_recyclerViewNewsPortal.setLayoutManager(layoutManager);
        v_recyclerViewNewsPortal.setHasFixedSize(false);
        NewsAdapter newsAdapter_ic = new NewsAdapter(newsDtoList, getApplicationContext());
        v_recyclerViewNewsPortal.setAdapter(newsAdapter_ic);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }
}
