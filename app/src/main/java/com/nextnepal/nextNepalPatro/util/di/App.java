package com.nextnepal.nextNepalPatro.util.di;

import android.app.Application;

import com.nextnepal.nextNepalPatro.myCard.module.CardModule;
import com.nextnepal.nextNepalPatro.activityFriends.module.FriendsListModule;
import com.nextnepal.nextNepalPatro.activityForex.module.ForexModule;
import com.nextnepal.nextNepalPatro.activityFriends.module.FriendsRequestModule;
import com.nextnepal.nextNepalPatro.activityLiveStream.module.LiveStreamModule;
import com.nextnepal.nextNepalPatro.activityLogin.module.LoginModule;
import com.nextnepal.nextNepalPatro.activityNews.module.NewsModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.DailyRashifalModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.MonthlyRashifalModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.WeeklyRashifalModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.YearlyRashifalModule;
import com.nextnepal.nextNepalPatro.activitySignUp.module.SignUpModule;
import com.nextnepal.nextNepalPatro.activityUsers.module.UsersModule;
import com.nextnepal.nextNepalPatro.cardReceived.module.ReceivedCardsModule;
import com.nextnepal.nextNepalPatro.profile.module.ProfileModule;

import net.danlew.android.joda.JodaTimeAndroid;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .newsModule(new NewsModule())
                .dailyRashifalModule(new DailyRashifalModule())
                .weeklyRashifalModule(new WeeklyRashifalModule())
                .monthlyRashifalModule(new MonthlyRashifalModule())
                .yearlyRashifalModule(new YearlyRashifalModule())
                .forexModule(new ForexModule())
                .signUpModule(new SignUpModule())
                .loginModule(new LoginModule())
                .liveStreamModule(new LiveStreamModule())
                .usersModule(new UsersModule())
                .friendsRequestModule(new FriendsRequestModule())
                .friendsListModule(new FriendsListModule())
                .profileModule(new ProfileModule())
                .cardModule(new CardModule())
                .receivedCardsModule(new ReceivedCardsModule())
                .build();
        JodaTimeAndroid.init(this);

    }

    public ApplicationComponent getComponent() {
        return component;
    }


}
