package com.nextnepal.nextNepalPatro.activityFriends.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsListContract;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendListDataDto;
import com.nextnepal.nextNepalPatro.activityFriends.view.adapter.FriendsListAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * This activity display friends of current logged users
 */
public class FriendsListFragment extends Fragment implements FriendsListContract.View {

    @Inject
    FriendsListContract.Presenter presenter;

    @BindView(R.id.friends)
    FrameLayout relativeLayout;

    @BindView(R.id.friendlist)
    RecyclerView fiendsListRecycler_v;



    private Unbinder unbinder_deo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_friends, container, false);
        unbinder_deo = ButterKnife.bind(this, view);
        Log.d("Running1","FriendList  Frag,emt");

        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        return view;
    }

    @Override
    public void loadFriends(List<FriendListDataDto> usersEntityList) {
        fiendsListRecycler_v.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        FriendsListAdapter friendsAdapter = new FriendsListAdapter(usersEntityList, getActivity());
        fiendsListRecycler_v.setAdapter(friendsAdapter);
        fiendsListRecycler_v.setHasFixedSize(false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder_deo.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG).show();
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

}
