package com.nextnepal.nextNepalPatro.myCard.view;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsListContract;
import com.nextnepal.nextNepalPatro.activityFriends.model.dto.FriendListDataDto;
import com.nextnepal.nextNepalPatro.activityFriends.view.adapter.FriendsListAdapter;
import com.nextnepal.nextNepalPatro.myCard.contract.CardSelection;
import com.nextnepal.nextNepalPatro.myCard.contract.CardSelectionContract;
import com.nextnepal.nextNepalPatro.myCard.model.Dto.CardSelectionEntity;
import com.nextnepal.nextNepalPatro.myCard.view.Adapter.CardSelectionAdapter;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.profile.contract.ProfileContract;
import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.util.di.App;
import com.nextnepal.nextNepalPatro.util.values.ProgressUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyCardFragment extends Fragment implements
        CardSelectionContract.View,
        FriendsListContract.View,
        CardSelection,
        ProfileContract.View {


    @BindView(R.id.recycler_card_selection)
    RecyclerView recyclerViewCard_v;

    @Inject
    CardSelectionContract.Presenter cardSelectionPresenter_ic;

    @Inject
    FriendsListContract.Presenter friendListPresenter;

    @Inject
    ProfileContract.Presenter profilePresenter;


    private Unbinder unbinder;

    private RecyclerView recyclerView;

    private List<FriendListDataDto> friendListDataDtoList;
    private ProgressDialog progressDialog;

    public static String designation_V;
    public static String organization_V;
    public static String facebookLink_V;
    public static String linkdenLink_V;
    public static String twitterLink_V;
    public static String phone_V;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_card_select, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        cardSelectionPresenter_ic.setView(this);
        friendListPresenter.setView(this);
        profilePresenter.setView(this);
        friendListDataDtoList = new ArrayList<>();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        cardSelectionPresenter_ic.loadData();
        friendListPresenter.loadData();
        profilePresenter.loadData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(recyclerViewCard_v, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(getActivity());
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
    public void loadCard(List<CardSelectionEntity> cardSelectionEntityArrayList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewCard_v.setLayoutManager(layoutManager);
        recyclerViewCard_v.setHasFixedSize(false);
        CardSelectionAdapter cardSelectionAdapter = new CardSelectionAdapter(getActivity(), cardSelectionEntityArrayList, this);
        recyclerViewCard_v.setAdapter(cardSelectionAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cardSelectionPresenter_ic.rxUnsubscribe();
    }

    /**
     * load friends into Bottom sheetDialog initializes values loadfriends(friendslistDatadtolist)
     */
    public void loadFriendList() {
        final BottomSheetDialog friendListBottomSheetDialog = new BottomSheetDialog(getActivity());
        friendListBottomSheetDialog.setContentView(R.layout.fragment_friends);
        recyclerView = friendListBottomSheetDialog.findViewById(R.id.friendlist);
        if (friendListDataDtoList.size() <= 0) {
            displayMessage("Try adding friends to share card's");
        } else {
            FriendsListAdapter friendsListAdapter = new FriendsListAdapter(friendListDataDtoList, getActivity());
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            recyclerView.setAdapter(friendsListAdapter);
            friendListBottomSheetDialog.show();
        }
    }

    @Override
    public void loadFriends(List<FriendListDataDto> usersEntityList) {
        this.friendListDataDtoList = usersEntityList;
    }

    @Override
    public void loadProfileDetail(ProfileDto profileDto) {
        if (profileDto != null) {
            designation_V = profileDto.getDesignation();
            organization_V = profileDto.getCompany();
            facebookLink_V = profileDto.getFacebook();
            twitterLink_V = profileDto.getTwitter();
            linkdenLink_V = profileDto.getLinkedin();
            phone_V = profileDto.getPhone();
        }
    }
}
