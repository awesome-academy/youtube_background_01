package com.framgia.youtube_background_01.screen.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.framgia.youtube_background_01.R;
import com.framgia.youtube_background_01.data.model.PlayList;
import com.framgia.youtube_background_01.data.model.Video;
import com.framgia.youtube_background_01.data.repository.VideoRepository;
import com.framgia.youtube_background_01.data.source.local.VideoLocalDataSource;
import com.framgia.youtube_background_01.data.source.remote.VideoRemoteDataSource;
import com.framgia.youtube_background_01.screen.home.adapter.PlaylistAdapter;
import com.framgia.youtube_background_01.screen.home.adapter.TrendingAdapter;
import java.util.List;

public class HomeFragment extends Fragment implements HomeContract.View {
    private TrendingAdapter mTrendingAdapter;
    private PlaylistAdapter mPlaylistAdapter;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        RecyclerView trendingRecyclerView = view.findViewById(R.id.recyclerViewTrending);
        trendingRecyclerView.setHasFixedSize(true);
        trendingRecyclerView.setNestedScrollingEnabled(false);
        mTrendingAdapter = new TrendingAdapter(getContext());
        trendingRecyclerView.setAdapter(mTrendingAdapter);

        RecyclerView playlistRecyclerView = view.findViewById(R.id.recyclerViewPlaylist);
        playlistRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        playlistRecyclerView.setHasFixedSize(true);
        playlistRecyclerView.setNestedScrollingEnabled(false);
        mPlaylistAdapter = new PlaylistAdapter(getContext());
        playlistRecyclerView.setAdapter(mPlaylistAdapter);
    }

    private void initData() {
        VideoRemoteDataSource trackRemoteDataSource = VideoRemoteDataSource.getInstance();
        VideoLocalDataSource trackLocalDataSource = VideoLocalDataSource.getInstance();
        VideoRepository repository =
                VideoRepository.getInstance(trackLocalDataSource, trackRemoteDataSource);
        HomeContract.Presenter presenter = new HomePresenter(repository);
        presenter.setView(this);
        presenter.getGetTrendingVideo();
        presenter.getPlayList();
    }

    @Override
    public void onGetPlaylistSuccess(List<PlayList> lists) {
        if (lists != null) {
            mPlaylistAdapter.updateData(lists);
        }
    }

    @Override
    public void onGetPlaylistError(Exception e) {
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetTrendingVideoSuccess(List<Video> lists) {
        if (lists != null) {
            mTrendingAdapter.updateData(lists);
        }
    }

    @Override
    public void onGetTrendingVideoError(Exception e) {
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
