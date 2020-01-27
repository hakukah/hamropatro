package com.nextnepal.nextNepalPatro.profile.view;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityFriends.view.FriendsListFragment;
import com.nextnepal.nextNepalPatro.myCard.view.MyCardFragment;
import com.nextnepal.nextNepalPatro.cardReceived.view.CardsReceivedFragment;
import com.nextnepal.nextNepalPatro.profile.contract.ProfileContract;
import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.util.di.App;
import com.nextnepal.nextNepalPatro.util.values.ProgressUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {

    @Inject
    ProfileContract.Presenter presenter;

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.profileImage)
    CircleImageView circleImageView;

    @BindView(R.id.email)
    TextView emailTextView;

    @BindView(R.id.edit)
    FloatingActionButton editFloationActionButton_v;

    @BindView(R.id.viewpager_card_sharing)
    ViewPager cardSharingViewPager;


    @BindView(R.id.tablayout_card_sharing)
    TabLayout cardSharingTabLayout;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        setupViewPager(cardSharingViewPager);
        cardSharingTabLayout.setupWithViewPager(cardSharingViewPager);
    }

    @Override
    public void loadProfileDetail(ProfileDto profileDto) {
        if (profileDto != null) {
            name.setText(profileDto.getFirstName() + " " + profileDto.getLastName());
            Glide.with(getApplicationContext()).load(profileDto.getImage()).into(circleImageView);
            emailTextView.setText(profileDto.getEmail());
        }
    }

    @OnClick(R.id.edit)
    void onEditClicked() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void displayMessage(String message) {

    }

    @Override
    public void showLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog = ProgressUtils.showProgressDialog(this);
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onSucess() {

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

    private void setupViewPager(ViewPager viewPager) {
        ProfileActivity.ViewPagerAdapter viewPagerAdapter = new ProfileActivity.ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new MyCardFragment(), "My Card");
        viewPagerAdapter.addFragment(new FriendsListFragment(), "Friends");
        viewPagerAdapter.addFragment(new CardsReceivedFragment(), "Received");
        viewPager.setAdapter(viewPagerAdapter);
    }
}
