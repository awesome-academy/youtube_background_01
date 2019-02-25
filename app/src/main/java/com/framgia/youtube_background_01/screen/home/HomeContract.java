package com.framgia.youtube_background_01.screen.home;

import com.framgia.youtube_background_01.data.model.PlayList;
import com.framgia.youtube_background_01.data.model.Video;
import com.framgia.youtube_background_01.screen.BasePresenter;
import java.util.List;

public interface HomeContract {
    interface View {
        void onGetPlaylistSuccess(List<PlayList> lists);

        void onGetPlaylistError(Exception e);

        void onGetTrendingVideoSuccess(List<Video> lists);

        void onGetTrendingVideoError(Exception e);
    }

    interface Presenter extends BasePresenter<View> {
        void getPlayList();

        void getGetTrendingVideo();
    }
}
