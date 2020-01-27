package com.nextnepal.nextNepalPatro.util.values.CONST;

import javax.inject.Singleton;

/**
 * Constant values that are required through out the app is found here
 */
@Singleton
public class CONST {
    public static String LOGIN_SUCCED = "Login sucessfully now you can browse and share card's";
    public static int SELECTED_YEAR;
    public static int SELECTED_MONTH;
    public static final String BBC_API_KEY = "baa195e773bf4481bf881f54ca0f6017";
    public static final String BBC_SOURCE = "bbc-news";

    /**
     * Const values required for radio
     */
    public static final String RADIO_IDLE = "IDLE";
    public static final String RADIO_LOADING = "PlaybackStatus_LOADING";
    public static final String RADIO_PLAYING = "PlaybackStatus_PLAYING";
    public static final String RADIO_PAUSED = "PlaybackStatus_PAUSED";
    public static final String RADIO_STOPPED = "PlaybackStatus_STOPPED";
    public static final String RADIO_ERROR = "PlaybackStatus_ERROR";

    public static final long STALE_MS = 1800000;
    public static final long STALE_FOREX_MS = 43200000;
    public static final long STALE_RASHIFAL_MS = 43200000;

    public static final long STALE_RASHIFAL = 21600000;

    public static final String NETWORK_ERROR = "Error loading FriendListDataDto";
    public static final String SUCCED = "Succed";
    public static final String FAILED = "Failed";

    public static final String FIELD_NULL_ERROR = "Field cannot be empty";
    public static final String FRIENDS_NULL = "Start Adding friends to list here";

    public static int DEFAULT_CARD_ID;

    public static final int INITIAL_YEAR = 2000;
    public static final int INITIAL_MONTH = 1;
    public static final int INITIAL_DAY = 1;

    public static final int FINISH_YEAR = 2025;
    public static final int FINISH_MONTH = 12;
    public static final int FINISH_DAY = 31;

    public static int CURRENT_YEAR=2000;
    public static int CURRENT_MONTH=1;
    public static int CURRENT_DAY=1;

    public static boolean ISCURRENT = true;

    public static class VideoPlayerConfig {
        public static final int MIN_BUFFER_DURATION = 3000;
        public static final int MAX_BUFFER_DURATION = 5000;
        public static final int MIN_PLAYBACK_START_BUFFER = 1500;
        public static final int MIN_PLAYBACK_RESUME_BUFFER = 5000;
        public static final String test = "https://www3.123movies.la/stream/The+Croods+2";
        public static final String DEFAULT_VIDEO_URL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
    }

}
