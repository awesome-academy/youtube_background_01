package com.framgia.youtube_background_01.utils;

import android.support.annotation.IntDef;

@IntDef({ QueryType.GET_VIDEOS, QueryType.SEARCH_VIDEO })

public @interface QueryType {
    int GET_VIDEOS = 0;
    int SEARCH_VIDEO = 1;
}
