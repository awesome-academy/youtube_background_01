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
import com.framgia.youtube_background_01.data.model.PlayList;
import com.framgia.youtube_background_01.utils.OnItemRecyclerViewListener;
import java.util.ArrayList;
import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    private Context mContext;
    private List<PlayList> mPlayLists;
    private OnItemRecyclerViewListener<PlayList> mOnItemRecyclerViewListener;

    public PlaylistAdapter(@NonNull Context context) {
        mContext = context;
        mPlayLists = new ArrayList<>();
    }

    public void updateData(List<PlayList> playLists) {
        mPlayLists.clear();
        mPlayLists.addAll(playLists);
        notifyDataSetChanged();
    }

    public void setOnItemRecyclerViewListener(
            OnItemRecyclerViewListener<PlayList> onItemRecyclerViewListener) {
        mOnItemRecyclerViewListener = onItemRecyclerViewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_playlist, parent, false);
        return new ViewHolder(mContext, view, mPlayLists, mOnItemRecyclerViewListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindViewData(mPlayLists.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlayLists != null ? mPlayLists.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context mContext;
        private List<PlayList> mPlayLists;
        private ImageView mPlaylistImageView;
        private TextView mTextTitle;
        private OnItemRecyclerViewListener<PlayList> mListener;

        ViewHolder(Context context, View itemView, List<PlayList> playLists,
                OnItemRecyclerViewListener<PlayList> listener) {
            super(itemView);
            mContext = context;
            mListener = listener;
            mPlayLists = playLists;

            mPlaylistImageView = itemView.findViewById(R.id.imageViewPlaylistItem);
            mTextTitle = itemView.findViewById(R.id.textViewPlaylistItem);
        }

        void bindViewData(PlayList playList) {
            mTextTitle.setText(playList.getType());
            getImageCircle(playList);
        }

        private void getImageCircle(PlayList playList) {
            Glide.with(mContext).load(playList.getImage()).into(mPlaylistImageView);
        }

        @Override
        public void onClick(View v) {
            if (mPlayLists != null) {
                mListener.onItemRecyclerViewClick(mPlayLists.get(getAdapterPosition()));
            }
        }
    }
}
