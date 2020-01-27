package com.nextnepal.nextNepalPatro.activityFriends.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityFriends.contract.FriendsListContract;
import com.nextnepal.nextNepalPatro.activityFriends.model.FriendsListModel;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.FriendsLIstRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.FriendsListRepository;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.FriendsRepository;
import com.nextnepal.nextNepalPatro.activityFriends.model.repositories.FriendsRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityFriends.presenter.FriendsListPresenter;
import com.nextnepal.nextNepalPatro.activityFriends.serivce.FriendsApiServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FriendsListModule {

    @Provides
    public FriendsListContract.Model providesModel(FriendsListRepository friendsRepository) {
        return new FriendsListModel(friendsRepository);
    }

    @Provides
    public FriendsListContract.Presenter providesPresenter(FriendsListContract.Model model) {
        return new FriendsListPresenter(model);
    }

    @Provides
    @Singleton
    public FriendsListRepository providesRepo(Context context, FriendsApiServices friendsApiServices) {
        return new FriendsLIstRepositoryIMPL(context, friendsApiServices);
    }
}
