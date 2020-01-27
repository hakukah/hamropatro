package com.nextnepal.nextNepalPatro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nextnepal.nextNepalPatro.activityCardSharing.CardSharingActivity;
import com.nextnepal.nextNepalPatro.activityForex.view.ForexActivity;
import com.nextnepal.nextNepalPatro.activityLive.view.LiveActivity;
import com.nextnepal.nextNepalPatro.activityLiveStream.view.LiveStreamActivity;
import com.nextnepal.nextNepalPatro.activityLogin.view.LoginActivity;
import com.nextnepal.nextNepalPatro.activityMain.View.adapter.MainActivityMenuAdapter;
import com.nextnepal.nextNepalPatro.activityMain.View.adapter.MainActivityNewsAdapter;
import com.nextnepal.nextNepalPatro.activityMain.contract.MainActivityContract;
import com.nextnepal.nextNepalPatro.activityMain.model.dto.MenuDto;
import com.nextnepal.nextNepalPatro.activityNews.contract.NewsContract;
import com.nextnepal.nextNepalPatro.activityNews.model.dto.DataEntity;
import com.nextnepal.nextNepalPatro.activityNews.model.entity.Data;
import com.nextnepal.nextNepalPatro.activityNews.view.NewsPortalActivity;
import com.nextnepal.nextNepalPatro.activityNews.view.adapter.NewsAdapter;
import com.nextnepal.nextNepalPatro.activityRadio.view.RadioActivity;
import com.nextnepal.nextNepalPatro.activityRashifal.view.RashifalActivity;
import com.nextnepal.nextNepalPatro.activityYoutube.YoutubeActivity;
import com.nextnepal.nextNepalPatro.calendar.contract.CalendarContract;
import com.nextnepal.nextNepalPatro.calendar.model.dto.EventDto;
import com.nextnepal.nextNepalPatro.calendar.model.dto.PatroDto;
import com.nextnepal.nextNepalPatro.calendar.view.CalendarActivity;
import com.nextnepal.nextNepalPatro.introActivity.view.IntroActivity;
import com.nextnepal.nextNepalPatro.profile.contract.ProfileContract;
import com.nextnepal.nextNepalPatro.profile.model.dto.ProfileDto;
import com.nextnepal.nextNepalPatro.profile.view.ProfileActivity;
import com.nextnepal.nextNepalPatro.util.di.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.CURRENT_DAY;
import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.CURRENT_MONTH;
import static com.nextnepal.nextNepalPatro.util.values.CONST.CONST.CURRENT_YEAR;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        NewsContract.View, MainActivityContract.View, ProfileContract.View, CalendarContract.View {

    @BindView(R.id.dateCurrent)
    TextView currentDate;

    @BindView(R.id.textDay)
    TextView textDay;
    @BindView(R.id.eventDayNepali)
    TextView eventDayNepali;

    @BindView(R.id.eventDayEnglish)
    TextView eventDayEnglish;

    @BindView(R.id.main_layout)
    LinearLayout layoutMain_v;

    @BindView(R.id.toolbar)
    Toolbar v_toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout v_drawer;

    @BindView(R.id.fab)
    FloatingActionButton v_fab;

    @BindView(R.id.nav_view)
    NavigationView v_navigationView;

    @BindView(R.id.recyclerview_news_headline)
    RecyclerView v_recyclerViewNewsHeadline;

    @BindView(R.id.see_all)
    TextView exploreNews;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @BindView(R.id.linear)
    RecyclerView recyclerViewMenu_v;

    @BindView(R.id.textRadio)
    CardView textRadio;

    @BindView(R.id.textVideo)
    CardView textVideo;

    @BindView(R.id.textForex)
    CardView textForex;

    @BindView(R.id.textRasifal)
    CardView textRasifal;


    NavigationView navigationView;


    //for displaying menu
    RecyclerView v_recyclerViewMenu;
    private MainActivityMenuAdapter ic_mainActivityMenuAdapter;


    @Inject
    NewsContract.Presenter presenter;

    @Inject
    MainActivityContract.Presenter presenterMain;

    @Inject
    ProfileContract.Presenter presenterProfile;

    @BindView(R.id.calendar_button)
    ConstraintLayout calendarButton;

    @Inject
    CalendarContract.Presenter calendarPresenter;


    private MainActivityNewsAdapter ic_mainActivityNewsAdapter;

    ViewHolder headerViewHolder;

    private CircleImageView imageView_account;
    private TextView userName;
    private TextView email_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadMenu();
        ((App) getApplication()).getComponent().inject(this);
        presenter.setView(this);
        presenterMain.setView(this);
        presenterProfile.setView(this);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View view = navigationView.getHeaderView(0);
        initView(view);
        if (!isNetworkConnected()) {
            Snackbar.make(layoutMain_v, "Network not Connected", Snackbar.LENGTH_LONG).show();
        }
        setSupportActionBar(v_toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, v_drawer, v_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        v_drawer.addDrawerListener(toggle);
        toggle.syncState();
        v_navigationView.setNavigationItemSelectedListener(this);
        calendarPresenter.setView(this);

//
//        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frameLayout, new CalendarFragment());
//        transaction.addToBackStack(null);
//        transaction.commit();


    }


    @OnClick(R.id.calendar_button)
    void onCalendarButtonClicked() {
        startActivity(new Intent(MainActivity.this, CalendarActivity.class));
    }


    void initView(View view) {
        imageView_account = view.findViewById(R.id.account);
        userName = view.findViewById(R.id.username);
        email_v = view.findViewById(R.id.email);

        imageView_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenterMain.checkIfLogged(getApplicationContext())) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        });
        email_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenterMain.checkIfLogged(getApplicationContext())) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        });
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (presenterMain.checkIfLogged(getApplicationContext())) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        });
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        textForex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForexActivity.class));
            }
        });
        textRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RadioActivity.class));
            }
        });
        textVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, YoutubeActivity.class));
            }
        });
        textRasifal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RashifalActivity.class));
            }
        });
    }

    @OnClick(R.id.see_all)
    public void transerNews() {
        startActivity(new Intent(MainActivity.this, NewsPortalActivity.class));
    }

    @Override
    public void initView() {
        Log.i("Init View", "Init View");
    }

    @Override
    public void displayMessage(String message) {
        Snackbar.make(layoutMain_v, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading(boolean isLoading) {

    }

    @Override
    public void onError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSucess() {

    }


    @Override
    public void updateData(List<Data> newsDtoList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        v_recyclerViewNewsHeadline.setLayoutManager(layoutManager);
        v_recyclerViewNewsHeadline.setHasFixedSize(false);
        NewsAdapter newsAdapter_ic = new NewsAdapter(newsDtoList, getApplicationContext());
        v_recyclerViewNewsHeadline.setAdapter(newsAdapter_ic);
    }


    @OnClick(R.id.fab)
    public void transferCard() {
        presenterMain.checkLogged(getApplicationContext());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri pickedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();
            String imagePath = cursor.getString(cursor.getColumnIndex(filePath[0]));

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
            cursor.close();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_rashifal) {
            startActivity(new Intent(MainActivity.this, RashifalActivity.class));
        }
        if (id == R.id.nav_forex) {
            startActivity(new Intent(MainActivity.this, ForexActivity.class));
        } else if (id == R.id.nav_login) {
            if (presenterMain.checkIfLogged(getApplicationContext())) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            } else {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        } else if (id == R.id.nav_radio) {
            startActivity(new Intent(MainActivity.this, RadioActivity.class));

        } else if (id == R.id.nav_videos) {
            startActivity(new Intent(MainActivity.this, LiveStreamActivity.class));
        } else if (id == R.id.nav_share) {
            if (presenterMain.checkIfLogged(getApplicationContext())) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            } else {
                onError("Login to build your profile");
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        } else if (id == R.id.nav_tv) {
            startActivity(new Intent(MainActivity.this, LiveActivity.class));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenterMain.checkIfLogged(getApplicationContext())) {
            hideItem();
        }
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
        presenterProfile.rxUnsubscribe();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadData();
        calendarPresenter.loadData();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);
                if (isFirstStart) {
                    final Intent i = new Intent(MainActivity.this, IntroActivity.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(i);
                        }
                    });

                    SharedPreferences.Editor editor = getPrefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();
                }
            }
        });
        t.start();
        if (presenterMain.checkIfLogged(getApplicationContext())) {
            presenterProfile.loadData();
            hideItem();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (presenterMain.checkIfLogged(getApplicationContext())) {
            hideItem();
        }
    }


    private void hideItem() {
        Menu nav_Menu = v_navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_login).setTitle("Card Sharing");
        //  nav_Menu.findItem(R.id.nav_login).setVisible(false);
    }

    @Override
    public void checkLogged(boolean loggedState) {
        if (loggedState) {
            startActivity(new Intent(MainActivity.this, CardSharingActivity.class));
        } else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }


    @Override
    public void loadProfileDetail(ProfileDto profileDto) {
        if (profileDto != null)
            userName.setText(profileDto.getFirstName() + " " + profileDto.getLastName());
        email_v.setText(profileDto.getEmail());
        Glide.with(getApplicationContext()).load(profileDto.getImage()).into(imageView_account);
    }

    @Override
    public void loadCalendar(List<PatroDto> patroDtoList) {

    }

    @Override
    public void loadDefaultEvent(EventDto eventDto) {
        if (eventDto != null) {
            eventDayNepali.setText(eventDto.getEventDetailNp());
            eventDayEnglish.setText(eventDto.getEventDetailEn());
        }
    }

    @Override
    public void loadDefaultMonth(int selectedYear, String selectedMonth, int day, String stringDay) {
        CURRENT_DAY = day;
        String currentDates = selectedYear + " " + selectedMonth + " " + day;
        currentDate.setText(currentDates);
        textDay.setText(String.valueOf(stringDay));
    }

    @Override
    public void loadSelectedMonthString(String stringMonth) {

    }

    @Override
    public void loadDefaultDateId(int selectedYear, int selectedMonth, int day) {

    }

    @Override
    public void getSelectedDate(List<PatroDto> patroDtoList) {

    }

    @Override
    public void displayListOfEvents(List<EventDto> eventDtoList) {

    }

    @Override
    public String getStringNepaliMonth(int i) {
        return null;
    }


    protected static class ViewHolder {

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    void loadMenu() {
        List<MenuDto> menuDtoList = new ArrayList<>();
        MenuDto menuDto;
        menuDto = new MenuDto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_live_tv_black_24dp), "name");
        menuDtoList.add(menuDto);
        menuDto = new MenuDto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_radio_black_24dp), "name");
        menuDtoList.add(menuDto);
        menuDto = new MenuDto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_star_black_24dp), "name");
        menuDtoList.add(menuDto);
        menuDto = new MenuDto(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_monetization_on_black_24dp), "name");
        menuDtoList.add(menuDto);
        MainActivityMenuAdapter mainActivityMenuAdapter = new MainActivityMenuAdapter(getApplicationContext(), menuDtoList);
        recyclerViewMenu_v.setAdapter(mainActivityMenuAdapter);
        recyclerViewMenu_v.setHasFixedSize(false);
    }


}
