package com.nextnepal.nextNepalPatro.activityRashifal.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityRashifal.contract.MonthlyRashifalContract;
import com.nextnepal.nextNepalPatro.activityRashifal.model.dto.RashifalDto;
import com.nextnepal.nextNepalPatro.activityRashifal.view.adapter.RashifalActivityAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MonthlyRashifalFragment extends Fragment implements MonthlyRashifalContract.View {

    @BindView(R.id.recyclerview_rashifal)
    RecyclerView v_rashifalRecyclerView;

    @Inject
    MonthlyRashifalContract.Presenter presenter;


    @BindView(R.id.relative_daily)
    RelativeLayout relativeLayout_daily;

    private Unbinder unbinder_deo;

    @BindView(R.id.date_display)
    TextView dateDisplay_v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_rashifal_daily, container, false);
        unbinder_deo = ButterKnife.bind(this, view);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        return view;

        /* final View view = inflater.inflate(R.layout.fragment_rashifal_daily, container, false);
        unbinder_deo = ButterKnife.bind(this, view);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        return view;*/
    }


    @Override
    public void updateData(List<RashifalDto> rashifalDtoList) {
        RashifalActivityAdapter rashifalActivityAdapter_ic = new RashifalActivityAdapter(rashifalDtoList, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        v_rashifalRecyclerView.setLayoutManager(layoutManager);
        v_rashifalRecyclerView.setHasFixedSize(false);
        v_rashifalRecyclerView.setAdapter(rashifalActivityAdapter_ic);
    }

    @Override
    public void setDate(String date) {
        if (date != null) {
            dateDisplay_v.setText(date);
        }
    }


    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout_daily, message, Snackbar.LENGTH_SHORT).show();
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
    public void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder_deo.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void initView() {

    }
}
