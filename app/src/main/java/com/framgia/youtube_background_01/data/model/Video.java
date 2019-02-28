package com.framgia.youtube_background_01.data.model;

public class Video {
    private String mId;
    private String mTitle;
    private String mUrlImage;
    private String mChannelTitle;

    public Video(VideoBuilder movieBuilder) {
        mId = movieBuilder.mId;
        mTitle = movieBuilder.mTitle;
        mUrlImage = movieBuilder.mUrlImage;
        mChannelTitle = movieBuilder.mChannelTitle;
    }

    public Video() {
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getChannelTitle() {
        return mChannelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        mChannelTitle = channelTitle;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public void setUrlImage(String urlImage) {
        mUrlImage = urlImage;
    }

    public static class VideoBuilder {
        private String mId;
        private String mTitle;
        private String mUrlImage;
        private String mChannelTitle;

        public VideoBuilder(String id, String title, String urlImage, String channelTitle) {
            mId = id;
            mTitle = title;
            mUrlImage = urlImage;
            mChannelTitle = channelTitle;
        }

        public VideoBuilder() {
        }

        public VideoBuilder setId(String id) {
            mId = id;
            return this;
        }

        public VideoBuilder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public VideoBuilder setUrlImage(String urlImage) {
            mUrlImage = urlImage;
            return this;
        }

        public VideoBuilder setChannelTitle(String channelTitle) {
            mChannelTitle = channelTitle;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }

    public final class VideoEntry {
        public static final String VIDEO = "items";
        public static final String ID_VIDEO = "videoId";
        public static final String TITLE = "title";
        public static final String URL_IMAGE = "url";
        public static final String CHANNEL_TITLE = "channelTitle";
    }
}
