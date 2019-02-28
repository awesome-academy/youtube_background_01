package com.framgia.youtube_background_01.utils;

import com.framgia.youtube_background_01.BuildConfig;

public final class Constant {
    public static final int REQUEST_TIMEOUT = 10000;
    public static final String GET_METHOD = "GET";
    public static final String ITEM = "items";
    public static final String SNIPPET = "snippet";
    public static final String THUMBNAILS = "thumbnails";
    public static final String HIGH = "high";
    public final static String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    public final static String BASE_QUERY_PLAYLIST = "playlistItems?part=snippet&playlistId=";
    public final static String BASE_MAX_RESULTS = "&maxResults=50";
    public final static String BASE_TRENDING = "PLUadgMpPaifVmhXn4xz-jRO934EAORUnX";
    public final static String BASE_PLAYLIST_URL = BASE_URL + BASE_QUERY_PLAYLIST;
    public final static String BASE_API_KEY = BASE_MAX_RESULTS + "&key=" + BuildConfig.API_KEY;
    public final static String BASE_TRENDING_URL =
            BASE_URL + BASE_QUERY_PLAYLIST + BASE_TRENDING + BASE_MAX_RESULTS + BASE_API_KEY;
}
