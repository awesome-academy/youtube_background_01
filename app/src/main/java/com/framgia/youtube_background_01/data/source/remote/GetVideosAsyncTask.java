package com.framgia.youtube_background_01.data.source.remote;

import android.os.AsyncTask;
import com.framgia.youtube_background_01.data.model.Video;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.framgia.youtube_background_01.utils.Constant.GET_METHOD;
import static com.framgia.youtube_background_01.utils.Constant.ITEM;
import static com.framgia.youtube_background_01.utils.Constant.REQUEST_TIMEOUT;
import static com.framgia.youtube_background_01.utils.Constant.SNIPPET;
import static com.framgia.youtube_background_01.utils.Constant.THUMBNAILS;

public class GetVideosAsyncTask extends AsyncTask<String, Void, List<Video>> {
    private OnFetchDataListener<Video> mListener;
    private Exception mException;
    private int mQueryType;

    public GetVideosAsyncTask(int queryType, OnFetchDataListener<Video> listener) {
        mListener = listener;
        mQueryType = queryType;
    }

    @Override
    protected List<Video> doInBackground(String... strings) {
        List<Video> videos = null;
        try {
            String json = getDataFromUrl(strings[0]);
            videos = readDataFromJson(json);
        } catch (Exception e) {
            e.printStackTrace();
            mException = e;
        }

        return videos;
    }

    @Override
    protected void onPostExecute(List<Video> videos) {
        super.onPostExecute(videos);
        if (mException != null) {
            mListener.onError(mException);
        }
        mListener.onSuccess(videos);
    }

    private String getDataFromUrl(String url) throws Exception {
        URL urlApi = new URL(url);
        HttpURLConnection mConnection = (HttpURLConnection) urlApi.openConnection();
        mConnection.setRequestMethod(GET_METHOD);
        mConnection.setReadTimeout(REQUEST_TIMEOUT);
        mConnection.setConnectTimeout(REQUEST_TIMEOUT);
        mConnection.connect();
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(mConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    private List<Video> readDataFromJson(String json) throws JSONException {
        List<Video> videos = new ArrayList<>();
        JSONObject rootObject = new JSONObject(json);
        JSONArray jsonArray = rootObject.getJSONArray(ITEM);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Video video = new Video.VideoBuilder().setId(object.getString(Video.VideoEntry.ID))
                    .setTitle(object.getJSONObject(SNIPPET).getString(Video.VideoEntry.TITLE))
                    .setChannelTitle(
                            object.getJSONObject(SNIPPET).getString(Video.VideoEntry.CHANNEL_TITLE))
                    .setUrlImage(object.getJSONObject(SNIPPET)
                            .getJSONObject(THUMBNAILS)
                            .getJSONObject("default")
                            .getString(Video.VideoEntry.URL_IMAGE))
                    .build();
            videos.add(video);
        }
        return videos;
    }
}
