package com.example.administrator.mynews.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.common.VedioInfo;
import com.example.administrator.mynews.common.Videolistenter;
import com.example.administrator.mynews.video.VideoEntity;
import com.example.videoplayer.part.SimpleVideoView;
import com.google.gson.Gson;

import net.youmi.android.normal.video.VideoActivity;
import net.youmi.android.normal.video.VideoAdManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VedioActivity extends AppCompatActivity  {
@BindView(R.id.video_simple)
    SimpleVideoView  mVideoView;

      public static  void open(Context context, VideoEntity videoEntity){
               Intent  intent=new Intent(context, VideoActivity.class);
          Gson  gson=new Gson();
          String s = gson.toJson(videoEntity);
          intent.putExtra("shuju",s);
          context.startActivity(intent);


      }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        ButterKnife.bind(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();

        String shuju = getIntent().getStringExtra("shuju");
           Gson gson=new Gson();
        VideoEntity videoEntity = gson.fromJson(shuju, VideoEntity.class);

        mVideoView.setVideoPath(videoEntity.getVideoUrl());


    }
}
