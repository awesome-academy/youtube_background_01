package com.framgia.youtube_background_01.utils;

import com.framgia.youtube_background_01.BuildConfig;

public final class Constant {

    public final static String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    public final static String BASE_PLAYLIST = "playlistItems?part=snippet&playlistId=";
    public final static String BASE_SEARCH = "search?part=snippet&q=";
    public final static String BASE_URL_IMAGE = "https://i.ytimg.com/vi/";
    public final static String BASE_MAX_RESULTS = "&maxResults=50";
    public final static String BASE_API_KEY = "&key=" + BuildConfig.API_KEY;
}
