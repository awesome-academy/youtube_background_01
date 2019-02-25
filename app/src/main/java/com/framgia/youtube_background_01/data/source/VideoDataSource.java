package com.framgia.youtube_background_01.data.source;

import com.framgia.youtube_background_01.data.model.PlayList;
import com.framgia.youtube_background_01.data.model.Video;
import com.framgia.youtube_background_01.data.source.remote.OnFetchDataListener;

public interface VideoDataSource {
    interface LocalDataSource {
        void getPlayList(OnFetchDataListener<PlayList> listener);
    }

    interface RemoteDataSource {
        void getTrendingVideos(OnFetchDataListener<Video> listener);
    }
}
