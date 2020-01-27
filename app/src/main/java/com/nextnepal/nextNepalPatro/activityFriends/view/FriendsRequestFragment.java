package com.nextnepal.nextNepalPatro.activityFriends.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsRequestContract;
import com.nextnepal.nextNepalPatro.activityFriends.view.adapter.SendFriendsRequestAdapter;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * This activity checks friends request received by current logged in users
 */
public class FriendsRequestFragment extends Fragment implements FriendsRequestContract.View {

    @Inject
    FriendsRequestContract.Presenter presenter;

    @BindView(R.id.friends)
    RelativeLayout relativeLayout;

    @BindView(R.id.friendlist)
    RecyclerView fiendsListRecycler_v;

    @BindView(R.id.nofriends)
    TextView noFriends_v;

    private Unbinder unbinder;

    @BindView(R.id.sadImage)
    ImageView noFriendsImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_friends_request, container, false);
        unbinder = ButterKnife.bind(this, view);
        Log.d("Running1", "FriendRequest Frag,emt");

        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
        return view;
    }

    @Override
    public void loadFriends(List<UsersEntity> usersEntityList) {
        if (usersEntityList.size() <= 0) {
            noFriends_v.setText("No Friends Request Found");
        }
        noFriendsImage.setVisibility(View.GONE);
        fiendsListRecycler_v.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        SendFriendsRequestAdapter friendsAdapter = new SendFriendsRequestAdapter(usersEntityList, getActivity());
        fiendsListRecycler_v.setAdapter(friendsAdapter);
        fiendsListRecycler_v.setHasFixedSize(false);
    }

    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {
      //  Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG).show();
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
    public void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }
}
