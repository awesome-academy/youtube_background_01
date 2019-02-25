package com.framgia.youtube_background_01.screen.home;

import com.framgia.youtube_background_01.data.model.PlayList;
import com.framgia.youtube_background_01.data.model.Video;
import com.framgia.youtube_background_01.data.repository.VideoRepository;
import com.framgia.youtube_background_01.data.source.remote.OnFetchDataListener;
import java.util.List;

public class HomePresenter implements HomeContract.Presenter {
    private VideoRepository mVideoRepository;
    private HomeContract.View mView;

    public HomePresenter(VideoRepository videoRepository) {
        mVideoRepository = videoRepository;
    }

    @Override
    public void getPlayList() {
        mVideoRepository.getPlaylist(new OnFetchDataListener<PlayList>() {
            @Override
            public void onSuccess(List<PlayList> data) {
                mView.onGetPlaylistSuccess(data);
            }

            @Override
            public void onError(Exception ex) {
                mView.onGetPlaylistError(ex);
            }
        });
    }

    @Override
    public void getGetTrendingVideo() {
        mVideoRepository.getTrendingVideos(new OnFetchDataListener<Video>() {
            @Override
            public void onSuccess(List<Video> data) {
                mView.onGetTrendingVideoSuccess(data);
            }

            @Override
            public void onError(Exception ex) {
                mView.onGetTrendingVideoError(ex);
            }
        });
    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }
}
