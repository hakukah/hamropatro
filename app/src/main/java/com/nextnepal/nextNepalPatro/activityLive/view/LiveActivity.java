package com.nextnepal.nextNepalPatro.activityLive.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ext.rtmp.RtmpDataSourceFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.nextnepal.nextNepalPatro.R;
import com.nextnepal.nextNepalPatro.util.values.CONST.CONST;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveActivity extends AppCompatActivity {

    @BindView(R.id.live_video)
    SimpleExoPlayerView simpleExoPlayerView;

    SimpleExoPlayer simpleExoPlayer;

    SimpleExoPlayer player;


    BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
    TrackSelector trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(bandwidthMeter));
    DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory("exoplayer_video");
    ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        ButterKnife.bind(this);
        //  initializePlayer();
        rmtpInitialize();
    }

    private void rmtpInitialize() {
        TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        PlayerView playerView = findViewById(R.id.live_video);
        playerView.setPlayer(player);
        RtmpDataSourceFactory rtmpDataSourceFactory = new RtmpDataSourceFactory();
        MediaSource videoSource = new ExtractorMediaSource.Factory(rtmpDataSourceFactory).createMediaSource(Uri.parse("rtmp://fms.105.net/live/rmc1"));
        player.prepare(videoSource);
        player.setPlayWhenReady(true);
    }

    private void initializePlayer() {
        Uri uri = Uri.parse(CONST.VideoPlayerConfig.DEFAULT_VIDEO_URL);
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(getApplicationContext(), trackSelector);
        simpleExoPlayer.clearVideoSurface();
        MediaSource mediaSource = new ExtractorMediaSource(uri, dataSourceFactory, extractorsFactory, null, null);
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.setPlayWhenReady(true);
        simpleExoPlayerView.setPlayer(simpleExoPlayer);
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //    simpleExoPlayer.setPlayWhenReady(true);
        //   simpleExoPlayer.getPlaybackState();
        player.setPlayWhenReady(true);
        player.getPlaybackState();
    }
}
