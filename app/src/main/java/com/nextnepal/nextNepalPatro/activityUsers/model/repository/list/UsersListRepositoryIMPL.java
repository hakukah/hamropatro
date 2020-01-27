package com.nextnepal.nextNepalPatro.activityUsers.model.repository.list;

import android.content.Context;

import com.nextnepal.nextNepalPatro.activityUsers.model.dto.UsersEntity;
import com.nextnepal.nextNepalPatro.activityUsers.service.UsersApiService;
import com.nextnepal.nextNepalPatro.util.values.BaseRepository;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class UsersListRepositoryIMPL extends BaseRepository implements UsersListRepository {
    private UsersApiService usersApiService;
    private Context context;
    private List<UsersEntity> usersEntityList;
    private long timeStamp;

    public UsersListRepositoryIMPL(Context context, UsersApiService usersApiService) {
        this.context = context;
        this.usersApiService = usersApiService;
        usersEntityList = new ArrayList<>();
        timeStamp = System.currentTimeMillis();
    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timeStamp < CONST.STALE_MS;
    }


    @Override
    public Observable<List<UsersEntity>> getUserList() {
      //  return getUserFromCache().switchIfEmpty(getUserFromNetwork());
        return getUserFromNetwork();
    }

    @Override
    public Observable<List<UsersEntity>> getUserFromCache() {
        if (isUpToDate()) {
            return Observable.fromArray(usersEntityList);
        } else {
            timeStamp = System.currentTimeMillis();
            usersEntityList.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<List<UsersEntity>> getUserFromNetwork() {
//        this.usersEntityList = (List<UsersEntity>) usersApiService.getUsersList("Bearer " + super.accessToken(context));
        return usersApiService.getUsersList("Bearer " + super.accessToken(context));
    }
}
