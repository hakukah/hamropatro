package com.nextnepal.nextNepalPatro.activityFriends.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsRequestContract;
import com.nextnepal.nextNepalPatro.activityFriends.model.FriendsRequestModel;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.request.FriendsRequestRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.request.FriendsRequestRepository;
import com.nextnepal.nextNepalPatro.activityFriends.presenter.FriendsRequestPresenter;
import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FriendsRequestModule {

    @Provides
    public FriendsRequestContract.Model providesModel(FriendsRequestRepository friendsRequestRepository) {
        return new FriendsRequestModel(friendsRequestRepository);
    }

    @Provides
    public FriendsRequestContract.Presenter providesPresenter(FriendsRequestContract.Model model, Context context) {
        return new FriendsRequestPresenter(model, context);
    }

    @Provides
    @Singleton
    public FriendsRequestRepository providesRepo(Context context, FriendsApiServices friendsApiServices) {
        return new FriendsRequestRepositoryIMPL(context, friendsApiServices);
    }
}
