package com.nextnepal.nextNepalPatro.activityRadio.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.activityRadio.RadioManager;
import com.nextnepal.nextNepalPatro.activityRadio.ShoutcastHelper;
import com.nextnepal.nextNepalPatro.activityRadio.ShoutcastListAdapter;
import com.nextnepal.nextNepalPatro.activityRadio.contract.RadioContract;
import com.nextnepal.nextNepalPatro.activityRadio.model.dto.StreamDto;
import com.nextnepal.nextNepalPatro.activityRadio.view.adapter.StreamAdapter;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class RadioActivity extends AppCompatActivity implements RadioContract.View {

    @BindView(R.id.playTrigger)
    ImageButton trigger;

    @BindView(R.id.listview)
    ListView listView;

    @BindView(R.id.name)
    TextView textView;

    @BindView(R.id.sub_player)
    View subPlayer;

    RadioManager radioManager;

    String streamURL;

    StreamAdapter streamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_radio);

        ButterKnife.bind(this);

        radioManager = RadioManager.with(this);
        streamAdapter = new StreamAdapter(getApplicationContext(), ShoutcastHelper.retrieveShoutcasts(this));

        /*
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        v_recyclerViewNewsHeadline.setLayoutManager(layoutManager);
        v_recyclerViewNewsHeadline.setHasFixedSize(false);
        ic_mainActivityNewsAdapter = new MainActivityNewsAdapter(headlinesDtoArrayList, getApplicationContext());
        v_recyclerViewNewsHeadline.setAdapter(ic_mainActivityNewsAdapter);*/
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//        listView.setLayoutManager(layoutManager);
//        listView.setHasFixedSize(false);
//
//        listView.setAdapter(streamAdapter);

        listView.setAdapter(new ShoutcastListAdapter(this, ShoutcastHelper.retrieveShoutcasts(this)));
    }

    @Override
    public void onStart() {

        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {

        EventBus.getDefault().unregister(this);

        super.onStop();
    }

    @Override
    protected void onDestroy() {

        radioManager.unbind();

        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();

        radioManager.bind();
    }

    @Override
    public void onBackPressed() {

        finish();
    }

    @Subscribe
    public void onEvent(String status) {

        switch (status) {

            case CONST.RADIO_LOADING:

                // loading

                break;

            case CONST.RADIO_ERROR:

                Toast.makeText(this, R.string.no_stream, Toast.LENGTH_SHORT).show();

                break;

        }

        trigger.setImageResource(status.equals(CONST.RADIO_PLAYING)
                ? R.drawable.ic_pause_black
                : R.drawable.ic_play_arrow_black);

    }

    @OnClick(R.id.playTrigger)
    public void onClicked() {

        if (TextUtils.isEmpty(streamURL)) return;

        radioManager.playOrPause(streamURL);
    }

    @OnItemClick(R.id.listview)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        StreamDto shoutcast = (StreamDto) parent.getItemAtPosition(position);
        if (shoutcast == null) {

            return;

        }

        textView.setText(shoutcast.getName());

        subPlayer.setVisibility(View.VISIBLE);

        streamURL = shoutcast.getUrl();

        radioManager.playOrPause(streamURL);
    }
}
