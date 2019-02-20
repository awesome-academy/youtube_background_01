package com.framgia.youtube_background_01.data.model;

public class Video {
    private int mId;
    private String mTitile;
    private String mUrlImage;
    private String mChannelTitle;

    public Video(VideoBuilder movieBuilder) {
        mId = movieBuilder.mId;
        mTitile = movieBuilder.mTitle;
        mUrlImage = movieBuilder.mUrlImage;
        mChannelTitle = movieBuilder.mChannelTitle;
    }

    public Video() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getChannelTitle() {
        return mChannelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        mChannelTitle = channelTitle;
    }

    public String getTitile() {
        return mTitile;
    }

    public void setTitile(String titile) {
        mTitile = titile;
    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public void setUrlImage(String urlImage) {
        mUrlImage = urlImage;
    }

    public static class VideoBuilder {
        private int mId;
        private String mTitle;
        private String mUrlImage;
        private String mChannelTitle;

        public VideoBuilder(int id, String title, String urlImage, String channelTitle) {
            mId = id;
            mTitle = title;
            mUrlImage = urlImage;
            mChannelTitle = channelTitle;
        }

        public VideoBuilder() {
        }

        public VideoBuilder id(int id) {
            mId = id;
            return this;
        }

        public VideoBuilder title(String title) {
            mTitle = title;
            return this;
        }

        public VideoBuilder urlImage(String urlImage) {
            mUrlImage = urlImage;
            return this;
        }

        public VideoBuilder channelTitle(String channelTitle) {
            mChannelTitle = channelTitle;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }

    public final class VideoEntry {
        public static final String VIDEO = "items";
        public static final String ID = "id";
        public static final String ID_VIDEO_FROM_SEARCH = "videoId";
        public static final String TITLE = "title";
        public static final String URL_IMAGE = "url";
        public static final String CHANNEL_TITLE = "channelTitle";
    }
}
