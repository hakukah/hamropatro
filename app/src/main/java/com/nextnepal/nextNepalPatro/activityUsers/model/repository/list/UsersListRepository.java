package com.nextnepal.nextNepalPatro.activityUsers.model.repository.list;

import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;

import java.util.List;

import io.reactivex.Observable;

public interface UsersListRepository {
    Observable<List<UsersEntity>> getUserList();

    Observable<List<UsersEntity>> getUserFromCache();

    Observable<List<UsersEntity>> getUserFromNetwork();
}
