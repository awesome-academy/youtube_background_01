package com.framgia.youtube_background_01.data.source.remote;

import java.util.List;

public interface OnFetchDataListener<T> {
    void onSuccess(List<T> data);

    void onError(Exception ex);
}
