package com.nextnepal.nextNepalPatro.activityLiveStream.view;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityLiveStream.contract.LiveStreamContract;
import com.nextnepal.nextNepalPatro.activityLiveStream.model.dto.LiveStreamDataDto;
import com.nextnepal.nextNepalPatro.util.di.App;
import com.nextnepal.nextNepalPatro.util.values.ProgressUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveStreamActivity extends AppCompatActivity implements LiveStreamContract.View {

    @BindView(R.id.recycler_live_tv)
    RecyclerView recyclerView_tv;

    @Inject
    LiveStreamContract.Presenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_stream);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    public void loadData(List<LiveStreamDataDto> liveStreamDataDtoList) {
        LiveStreamAdapter liveStreamAdapter = new LiveStreamAdapter(liveStreamDataDtoList, getApplicationContext());
        recyclerView_tv.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView_tv.setAdapter(liveStreamAdapter);
        recyclerView_tv.setHasFixedSize(false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(recyclerView_tv, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(this);
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSucess() {

    }


}
