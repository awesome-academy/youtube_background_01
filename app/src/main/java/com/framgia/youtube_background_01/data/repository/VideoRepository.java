package com.framgia.youtube_background_01.data.repository;

import com.framgia.youtube_background_01.data.model.PlayList;
import com.framgia.youtube_background_01.data.model.Video;
import com.framgia.youtube_background_01.data.source.VideoDataSource;
import com.framgia.youtube_background_01.data.source.remote.OnFetchDataListener;

public class VideoRepository {
    private static VideoRepository sInstance;
    private VideoDataSource.LocalDataSource mLocalDataSource;
    private VideoDataSource.RemoteDataSource mRemoteDataSource;

    public VideoRepository(VideoDataSource.LocalDataSource localDataSource,
            VideoDataSource.RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    public static VideoRepository getInstance(VideoDataSource.LocalDataSource mLocalDataSource,
            VideoDataSource.RemoteDataSource mRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new VideoRepository(mLocalDataSource, mRemoteDataSource);
        }
        return sInstance;
    }

    public void getPlaylist(OnFetchDataListener<PlayList> listener) {
        mLocalDataSource.getPlayList(listener);
    }

    public void getTrendingVideos(OnFetchDataListener<Video> listener) {
        mRemoteDataSource.getTrendingVideos(listener);
    }
}
