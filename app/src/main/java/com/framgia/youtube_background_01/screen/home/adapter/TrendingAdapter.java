package com.framgia.youtube_background_01.screen.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.framgia.youtube_background_01.R;
import com.framgia.youtube_background_01.data.model.Video;
import com.framgia.youtube_background_01.utils.OnItemRecyclerViewListener;
import java.util.ArrayList;
import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
    private Context mContext;
    private List<Video> mMovieList;
    private OnItemRecyclerViewListener<Video> mOnItemRecyclerViewListener;

    public TrendingAdapter(@NonNull Context context) {
        mContext = context;
        mMovieList = new ArrayList<>();
    }

    public void updateData(List<Video> videos) {
        mMovieList.clear();
        mMovieList.addAll(videos);
        notifyDataSetChanged();
    }

    public void setOnItemRecyclerViewListener(
            OnItemRecyclerViewListener<Video> onItemRecyclerViewListener) {
        mOnItemRecyclerViewListener = onItemRecyclerViewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_trending, parent, false);
        return new ViewHolder(mContext, view, mMovieList, mOnItemRecyclerViewListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindViewData(mMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList != null ? mMovieList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context mContext;
        private List<Video> mVideoList;
        private ImageView mImageView;
        private TextView mTextTitle, mAuthor;
        private OnItemRecyclerViewListener<Video> mListener;

        ViewHolder(Context context, View itemView, List<Video> movieList,
                OnItemRecyclerViewListener<Video> listener) {
            super(itemView);
            mContext = context;
            mListener = listener;
            mVideoList = movieList;

            mImageView = itemView.findViewById(R.id.imageViewTrendingItem);
            mAuthor = itemView.findViewById(R.id.textAuthorTrendingItem);
            mTextTitle = itemView.findViewById(R.id.textTitleTrendingItem);
        }

        void bindViewData(Video movie) {
            mTextTitle.setText(movie.getTitle());
            mAuthor.setText(movie.getChannelTitle());
            getImageCircle(movie);
        }

        private void getImageCircle(Video movie) {
            Glide.with(mContext).load(movie.getUrlImage()).into(mImageView);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemRecyclerViewClick(mVideoList.get(getAdapterPosition()));
            }
        }
    }
}
