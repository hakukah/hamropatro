package com.nextnepal.nextNepalPatro.activityRashifal.view;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.DailyRashifalFragment;
import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.MonthlyRashifalFragment;
import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.WeeklyRashifalFragment;
import com.nextnepal.nextNepalPatro.activityRashifal.view.fragments.YearlyRashifalFragment;
import com.nextnepal.nextNepalPatro.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RashifalActivity extends AppCompatActivity {


    @BindView(R.id.viewpager_rashifal)
    ViewPager v_viewPager;

    @BindView(R.id.tablayout_rashifal)
    TabLayout v_tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rashifal);
        ButterKnife.bind(this);
        setupViewPager(v_viewPager);
        v_tabLayout.setupWithViewPager(v_viewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new DailyRashifalFragment(), "Daily");
        viewPagerAdapter.addFragment(new WeeklyRashifalFragment(), "Weekly");
        viewPagerAdapter.addFragment(new MonthlyRashifalFragment(), "Monthly");
       viewPagerAdapter.addFragment(new YearlyRashifalFragment(), "Yearly");
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
