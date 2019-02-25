package com.framgia.youtube_background_01.data.source.local;

import com.framgia.youtube_background_01.R;
import com.framgia.youtube_background_01.data.model.PlayList;
import com.framgia.youtube_background_01.data.source.VideoDataSource;
import com.framgia.youtube_background_01.data.source.remote.OnFetchDataListener;
import com.framgia.youtube_background_01.utils.PlayLists;
import java.util.ArrayList;
import java.util.List;

public class VideoLocalDataSource implements VideoDataSource.LocalDataSource {
    private static VideoLocalDataSource sInstance;

    public static VideoLocalDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new VideoLocalDataSource();
        }
        return sInstance;
    }

    @Override
    public void getPlayList(OnFetchDataListener<PlayList> listener) {
        List<PlayList> list = new ArrayList<>();
        list.add(new PlayList(PlayLists.TOP_MUSIC_TITLE, R.drawable.img_top_music,
                PlayLists.TOP_MUSIC));
        list.add(new PlayList(PlayLists.DANCE_TITLE, R.drawable.img_top_dance, PlayLists.DANCE));
        list.add(new PlayList(PlayLists.DEEP_HOUSE_TITLE, R.drawable.img_top_edm,
                PlayLists.DEEP_HOUSE));
        list.add(new PlayList(PlayLists.VIOLIN_COVER_TITLE, R.drawable.img_top_music,
                PlayLists.VIOLIN_COVER));
        listener.onSuccess(list);
    }
}
