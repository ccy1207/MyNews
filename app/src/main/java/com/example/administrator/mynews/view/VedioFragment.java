package com.example.administrator.mynews.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mynews.R;


import com.example.administrator.mynews.video.VideoItemView;
import com.example.administrator.mynews.video.VideoListView;
import com.example.videoplayer.list.MediaPlayerManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class VedioFragment extends Fragment {


    private VideoListView mListView;

    public VedioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vedio, container, false);
        mListView = (VideoListView) view.findViewById(R.id.videolist);

        mListView.atuoRefresh();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mListView.post(new Runnable() {
            @Override
            public void run() {


            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        MediaPlayerManager.getsInstance(getContext()).onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        MediaPlayerManager.getsInstance(getContext()).onPause();
    }
}
