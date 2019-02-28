package com.framgia.youtube_background_01.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PlayList implements Parcelable {
    private String mType;
    private String mId;
    private int mImage;

    public PlayList(String type, int url, String id) {
        mType = type;
        mId = id;
        mImage = url;
    }

    public PlayList(Parcel in) {
        mId = in.readString();
        mType = in.readString();
        mImage = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mType);
        dest.writeInt(mImage);
    }

    public static final Creator<PlayList> CREATOR = new Creator<PlayList>() {
        @Override
        public PlayList createFromParcel(Parcel in) {
            return new PlayList(in);
        }

        @Override
        public PlayList[] newArray(int size) {
            return new PlayList[size];
        }
    };

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }
}
