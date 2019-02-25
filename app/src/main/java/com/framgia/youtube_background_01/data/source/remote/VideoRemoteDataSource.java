package com.framgia.youtube_background_01.data.source.remote;

import com.framgia.youtube_background_01.data.model.Video;
import com.framgia.youtube_background_01.data.source.VideoDataSource;
import com.framgia.youtube_background_01.utils.QueryType;

import static com.framgia.youtube_background_01.utils.Constant.BASE_TRENDING_URL;

public class VideoRemoteDataSource implements VideoDataSource.RemoteDataSource {
    private static VideoRemoteDataSource sInstance;

    public static VideoRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new VideoRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getTrendingVideos(OnFetchDataListener<Video> listener) {
        new GetVideosAsyncTask(QueryType.GET_VIDEOS, listener).execute(BASE_TRENDING_URL);
    }
}
