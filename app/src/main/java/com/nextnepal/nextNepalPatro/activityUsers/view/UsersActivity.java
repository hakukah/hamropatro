package com.nextnepal.nextNepalPatro.activityUsers.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityUsers.contract.UsersContract;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.activityUsers.view.adapter.UsersAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UsersActivity extends Fragment implements UsersContract.View {

    @Inject
    UsersContract.Presenter presenter;

    @BindView(R.id.recycler_users)
    RecyclerView recyclerView;

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadData();
    }

    //    @Override
//     void onStart() {
//        super.onStart();
//        presenter.loadData();
//        presenter.setView(this);
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_users);
//        ButterKnife.bind(this);
//        ((App) getApplication()).getComponent().inject(this);
//        presenter.setView(this);
//    }

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_users, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        return view;
    }

    @Override
    public void loadUserList(List<UsersEntity> usersEntityList) {
        UsersAdapter usersAdapter = new UsersAdapter(usersEntityList, getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(usersAdapter);
        recyclerView.setHasFixedSize(false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {

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
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }
}
