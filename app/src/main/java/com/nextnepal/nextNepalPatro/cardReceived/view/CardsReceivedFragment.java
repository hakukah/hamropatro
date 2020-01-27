package com.nextnepal.nextNepalPatro.cardReceived.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.cardReceived.contract.CardsReceivedContract;
import com.nextnepal.nextNepalPatro.cardReceived.model.dto.CardReceivedDto;
import com.nextnepal.nextNepalPatro.cardReceived.view.adapter.CardReceivedAdapter;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CardsReceivedFragment extends Fragment implements CardsReceivedContract.View {

    @Inject
    CardsReceivedContract.Presenter presenter;

    private Unbinder unbinder;

    @BindView(R.id.cards_received)
    RecyclerView recyclerViewCardsReceived_v;

    @BindView(R.id.sad)
    ImageView sadImageView_v;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cards_received, container, false);
        unbinder = ButterKnife.bind(this, view);
        ((App) getActivity().getApplication()).getComponent().inject(this);
        presenter.setView(this);
       // presenter.loadData();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
       // presenter.loadData();
    }

    @Override
    public void receivedCard(List<CardReceivedDto> cardReceivedDtos) {
        if (cardReceivedDtos != null) {
            sadImageView_v.setVisibility(View.VISIBLE);
            CardReceivedAdapter cardReceivedAdapter = new CardReceivedAdapter(getActivity(), cardReceivedDtos);
            recyclerViewCardsReceived_v.setLayoutManager(new GridLayoutManager(getContext(), 1));
            recyclerViewCardsReceived_v.setAdapter(cardReceivedAdapter);
            recyclerViewCardsReceived_v.setHasFixedSize(false);
        } else {
            displayMessage("You have not received any cards");
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
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

}
