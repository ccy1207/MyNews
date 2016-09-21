package com.example.administrator.mynews.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.comment.CommentListView;
import com.example.administrator.mynews.video.TitleTextView;
import com.example.administrator.mynews.video.VideoEntity;
import com.example.videoplayer.part.SimpleVideoView;
import com.google.gson.Gson;
import com.opendanmaku.DanmakuItem;
import com.opendanmaku.DanmakuView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SimpleVideoActivity extends AppCompatActivity implements CommentListView.CommentListenter {

    SimpleVideoView mVideoView;
    TitleTextView video_tv;
    Toolbar tab;
    @BindView(R.id.simple_ev)
    EditText mSimpleEv;
    @BindView(R.id.simple_send)
    Button mSimpleSend;
    @BindView(R.id.simple_dan)
    Button mSimpleDan;
    private CommentListView mComListView;
    private VideoEntity mVideoEntity;
    DanmakuView danmakuItem;
    boolean  isDanmuRun=true;
    private ArrayList<String> mComment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        ButterKnife.bind(this);
        mVideoView = (SimpleVideoView) findViewById(R.id.video_simple);
        video_tv = (TitleTextView) findViewById(R.id.video_title);
        tab = (Toolbar) findViewById(R.id.video_tab);
        danmakuItem = (DanmakuView) findViewById(R.id.danmu);
        mComListView = (CommentListView) findViewById(R.id.comment_list);
        mComListView.setCommentListenter(this);

        setSupportActionBar(tab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String shuju = getIntent().getStringExtra("shuju");
        Gson gson = new Gson();
        mVideoEntity = gson.fromJson(shuju, VideoEntity.class);
        video_tv.setText(mVideoEntity.getNewsTitle());
        ;
        mVideoView.setVideoPath(mVideoEntity.getVideoUrl());


        mComListView.setNewsId(mVideoEntity.getObjectId());
        mComListView.atuoRefresh();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public static void open(Context context, VideoEntity videoEntity) {
        Intent intent = new Intent(context, SimpleVideoActivity.class);
        Gson gson = new Gson();
        String s = gson.toJson(videoEntity);
        intent.putExtra("shuju", s);
        context.startActivity(intent);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView.onResume();

        danmakuItem.show();
        isDanmuRun=true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoView.onPause();
        danmakuItem.clear();

    }

    @Override
    public void setData(ArrayList<String> list) {
        mComment = list;
        for (int i = 0; i < mComment.size(); i++) {
            DanmakuItem item = new DanmakuItem(this, mComment.get(i), danmakuItem.getWidth());
            item.setTextColor(Color.BLUE);
            item.setTextSize(20);


            danmakuItem.addItem(item);


        }

    }

    @OnClick({R.id.simple_send, R.id.simple_dan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simple_send:
                Log.d("simple_send", "onClick: dianji"+mSimpleEv.getText().toString());
                if (mSimpleEv.getText()!=null){
                    DanmakuItem item = new DanmakuItem(this,mSimpleEv.getText().toString(), danmakuItem.getWidth());
                    danmakuItem.addItem(item);
                mSimpleEv.setText(null);
                }
                break;
            case R.id.simple_dan:
              //
                if (isDanmuRun){
               //     Log.d("danmu", "onClick: guan");
                    danmakuItem.hide();
                    isDanmuRun=false;
                    mSimpleDan.setBackgroundResource(R.drawable.dan_stop);
                }else {
               //     Log.d("danmu", "onClick:kai ");
                    danmakuItem.show();
                    isDanmuRun=true;
                    mSimpleDan.setBackgroundResource(R.drawable.dan_start);
                }
                break;
        }
    }
}