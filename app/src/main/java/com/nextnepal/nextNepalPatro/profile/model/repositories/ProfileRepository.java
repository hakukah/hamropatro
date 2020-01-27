package com.nextnepal.nextNepalPatro.profile.model.repositories;

import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;

import io.reactivex.Observable;

public interface ProfileRepository {
    Observable<ProfileDto> getProfileInfo();

    Observable<ProfileDto> getProfileFromCache();

    Observable<ProfileDto> getProfileFromNetwork();
}
