package com.nextnepal.nextNepalPatro.activityUsers.model;

import com.nextnepal.nextNepalPatro.activityUsers.contract.UsersContract;
import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.activityUsers.model.repository.list.UsersListRepository;

import java.util.List;

import io.reactivex.Observable;

public class UsersListModel implements UsersContract.Model {
    private UsersListRepository usersListRepository;

    public UsersListModel(UsersListRepository usersListRepository) {
        this.usersListRepository = usersListRepository;
    }

    @Override
    public Observable<List<UsersEntity>> getUserList() {
        return usersListRepository.getUserList();
    }
}
