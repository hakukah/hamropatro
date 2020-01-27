package com.nextnepal.nextNepalPatro.activityForex.view;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityForex.contract.ForexContract;
import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.activityForex.view.adapter.ForexAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;
import com.nextnepal.nextNepalPatro.util.values.ProgressUtils;

import java.util.List;
import java.util.logging.Level;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForexActivity extends AppCompatActivity implements ForexContract.View {


    @BindView(R.id.recycler_forex)
    RecyclerView recyclerViewForex_v;

    @Inject
    ForexContract.Presenter presenter;

    @BindView(R.id.realtive_forex)
    RelativeLayout forexRelativeLayout;
    private ProgressDialog progressDialog;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);

    }

    @Override
    public void loadData(List<ForexEntity> forexEntityList) {
        ForexAdapter forexAdapter = new ForexAdapter(forexEntityList, getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewForex_v.setLayoutManager(layoutManager);
        recyclerViewForex_v.setHasFixedSize(false);
        recyclerViewForex_v.setAdapter(forexAdapter);

    }

    @Override
    public void initView() {
        Log.i(ForexActivity.class.getSimpleName(), ForexActivity.class.getSimpleName());
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(forexRelativeLayout, message, Snackbar.LENGTH_LONG).show();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }
}
