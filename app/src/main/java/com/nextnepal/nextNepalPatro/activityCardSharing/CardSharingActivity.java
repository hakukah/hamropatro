package com.nextnepal.nextNepalPatro.activityCardSharing;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.myCard.view.MyCardFragment;
import com.nextnepal.nextNepalPatro.activityFriends.view.FriendsRequestFragment;
import com.nextnepal.nextNepalPatro.activityUsers.view.UsersActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardSharingActivity extends AppCompatActivity {

    @BindView(R.id.viewpager_card_sharing)
    ViewPager cardSharingViewPager;


    @BindView(R.id.tablayout_card_sharing)
    TabLayout cardSharingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_sharing);
        ButterKnife.bind(this);
        setupViewPager(cardSharingViewPager);
        cardSharingTabLayout.setupWithViewPager(cardSharingViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        CardSharingActivity.ViewPagerAdapter viewPagerAdapter = new CardSharingActivity.ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new MyCardFragment(), "My Cards");
        viewPagerAdapter.addFragment(new UsersActivity(), "Discover");
        viewPagerAdapter.addFragment(new FriendsRequestFragment(), "Request");
        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> stringList = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            stringList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
    }
}
