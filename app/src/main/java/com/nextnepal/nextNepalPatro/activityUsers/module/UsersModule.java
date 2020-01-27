package com.nextnepal.nextNepalPatro.activityUsers.module;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityUsers.contract.UsersContract;
import com.nextnepal.nextNepalPatro.activityUsers.model.UsersListModel;
import com.nextnepal.nextNepalPatro.activityUsers.model.repository.list.UsersListRepository;
import com.nextnepal.nextNepalPatro.activityUsers.model.repository.list.UsersListRepositoryIMPL;
import com.nextnepal.nextNepalPatro.activityUsers.presenter.UserListPresenter;
import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersModule {
    @Provides
    public UsersContract.Presenter providesPresenter(UsersContract.Model model) {
        return new UserListPresenter(model);
    }

    @Provides
    public UsersContract.Model providesModel(UsersListRepository usersListRepository) {
        return new UsersListModel(usersListRepository);
    }

    @Provides
    @Singleton
    public UsersListRepository providesRepo(Context context, UsersApiService usersApiService) {
        return new UsersListRepositoryIMPL(context, usersApiService);
    }
}
