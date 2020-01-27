package com.nextnepal.nextNepalPatro.util.di;

import com.nextnepal.nextNepalPatro.MainActivity;
import com.nextnepal.nextNepalPatro.activityCardDetails.view.CardDetailsActivity;
import com.nextnepal.nextNepalPatro.activityCardDetails.module.UserInfoApiModule;
import com.nextnepal.nextNepalPatro.activityCardDetails.module.UserInfoModule;
import com.nextnepal.nextNepalPatro.activityForex.module.ForexApiModule;
import com.nextnepal.nextNepalPatro.activityForex.module.ForexModule;
import com.nextnepal.nextNepalPatro.activityForex.view.ForexActivity;
import com.nextnepal.nextNepalPatro.activityFriends.module.FriendsListModule;
import com.nextnepal.nextNepalPatro.activityFriends.module.FriendsRequestApiModule;
import com.nextnepal.nextNepalPatro.activityFriends.module.FriendsRequestModule;
import com.nextnepal.nextNepalPatro.activityFriends.view.FriendsListFragment;
import com.nextnepal.nextNepalPatro.activityFriends.view.FriendsRequestFragment;
import com.nextnepal.nextNepalPatro.activityLiveStream.module.LiveStreamApiModule;
import com.nextnepal.nextNepalPatro.activityLiveStream.module.LiveStreamModule;
import com.nextnepal.nextNepalPatro.activityLiveStream.view.LiveStreamActivity;
import com.nextnepal.nextNepalPatro.activityLogin.module.LoginApiModule;
import com.nextnepal.nextNepalPatro.activityLogin.module.LoginModule;
import com.nextnepal.nextNepalPatro.activityLogin.view.LoginActivity;
import com.nextnepal.nextNepalPatro.activityMain.module.MainActivityModule;
import com.nextnepal.nextNepalPatro.myCard.module.CardApiModule;
import com.nextnepal.nextNepalPatro.myCard.module.CardModule;
import com.nextnepal.nextNepalPatro.myCard.view.MyCardFragment;
import com.nextnepal.nextNepalPatro.activityNews.module.NewsModule;
import com.nextnepal.nextNepalPatro.activityNews.module.api.NewsApiModule;
import com.nextnepal.nextNepalPatro.activityNews.view.NewsPortalActivity;
import com.nextnepal.nextNepalPatro.activityRashifal.module.DailyRashifalModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.MonthlyRashifalModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.WeeklyRashifalModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.YearlyRashifalModule;
import com.nextnepal.nextNepalPatro.activityRashifal.module.api.RashifalApiModule;
import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.DailyRashifalFragment;
import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.MonthlyRashifalFragment;
import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.WeeklyRashifalFragment;
import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.YearlyRashifalFragment;
import com.nextnepal.nextNepalPatro.activitySignUp.module.SignUpApiModule;
import com.nextnepal.nextNepalPatro.activitySignUp.module.SignUpModule;
import com.nextnepal.nextNepalPatro.activitySignUp.view.EmailSignUpActivity;
import com.nextnepal.nextNepalPatro.activityUsers.module.UsersApiModule;
import com.nextnepal.nextNepalPatro.activityUsers.module.UsersModule;
import com.nextnepal.nextNepalPatro.activityUsers.view.UsersActivity;
import com.nextnepal.nextNepalPatro.calendar.module.CalendarModule;
import com.nextnepal.nextNepalPatro.calendar.view.CalendarActivity;
import com.nextnepal.nextNepalPatro.calendar.view.CalendarPatroFragment;
import com.nextnepal.nextNepalPatro.cardReceived.module.ReceivedCardsApiModule;
import com.nextnepal.nextNepalPatro.cardReceived.module.ReceivedCardsModule;
import com.nextnepal.nextNepalPatro.cardReceived.view.CardsReceivedFragment;
import com.nextnepal.nextNepalPatro.profile.module.ProfileApiModule;
import com.nextnepal.nextNepalPatro.profile.module.ProfileModule;
import com.nextnepal.nextNepalPatro.profile.view.ProfileActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, MainActivityModule.class,
        NewsModule.class, NewsApiModule.class,
        DailyRashifalModule.class, RashifalApiModule.class,
        WeeklyRashifalModule.class,
        MonthlyRashifalModule.class,
        YearlyRashifalModule.class,
        ForexModule.class, ForexApiModule.class,
        SignUpModule.class, SignUpApiModule.class,
        LoginModule.class, LoginApiModule.class,
        LiveStreamModule.class, LiveStreamApiModule.class,
        UsersApiModule.class, UsersModule.class,
        FriendsRequestApiModule.class, FriendsRequestModule.class,
        FriendsListModule.class,
        ProfileApiModule.class, ProfileModule.class,
        CardModule.class, CardApiModule.class,
        ReceivedCardsApiModule.class, ReceivedCardsModule.class,
        UserInfoApiModule.class, UserInfoModule.class,
        CalendarModule.class
})
public interface ApplicationComponent {

    void inject(NewsPortalActivity newsPortalActivity);

    void inject(MainActivity mainActivity);

    void inject(DailyRashifalFragment dailyRashifalFragment);

    void inject(MonthlyRashifalFragment monthlyRashifalFragment);

    void inject(WeeklyRashifalFragment weeklyRashifalFragment);

    void inject(YearlyRashifalFragment yearlyRashifalFragment);

    void inject(ForexActivity forexActivity);

    void inject(EmailSignUpActivity emailSignUpActivity);

    void inject(LiveStreamActivity liveStreamActivity);

    void inject(LoginActivity loginActivity);


    void inject(UsersActivity usersActivity);

    void inject(FriendsRequestFragment friendsRequestFragment);

    void inject(FriendsListFragment friendsListFragment);

    void inject(ProfileActivity profileActivity);

    void inject(MyCardFragment myCardFragment);

    void inject(CardsReceivedFragment cardsReceivedFragment);

    void inject(CardDetailsActivity cardDetailsActivity);

    void inject(CalendarActivity calendarActivity);

    void inject(CalendarPatroFragment calendarPatroFragment);

}
