package com.nextnepal.nextNepalPatro.activityForex.model;

import com.nextnepal.nextNepalPatro.activityForex.contract.ForexContract;
import com.nextnepal.nextNepalPatro.activityForex.model.dto.ForexEntity;
import com.nextnepal.nextNepalPatro.activityForex.model.repositories.ForexRepository;

import java.util.List;

import io.reactivex.Observable;

public class ForexModel implements ForexContract.Model {
    private ForexRepository forexRepository;

    public ForexModel(ForexRepository forexRepository) {
        this.forexRepository = forexRepository;
    }

    @Override
    public Observable<List<ForexEntity>> getForex() {
        return forexRepository.getForex();
    }

}
