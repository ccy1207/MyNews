package com.example.administrator.mynews.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.ui.SimpleVideoActivity;
import com.example.administrator.mynews.ui.VedioActivity;
import com.example.videoplayer.list.MediaPlayerManager;
import com.squareup.picasso.Picasso;

import net.youmi.android.normal.video.VideoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/12.
 */
public class VideoItemView extends FrameLayout implements
        MediaPlayerManager.OnPlaybackListener,
        TextureView.SurfaceTextureListener{

    private MediaPlayerManager mInstance;
    private String mPath;
    private String mVideoId;
    private VideoEntity mVideoEntity1;

    public VideoItemView(Context context) {
        this(context, null,0);
    }

    public VideoItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }
    @BindView(R.id.textureView)
    TextureView textureView; // 用来展现视频的TextureView
    @BindView(R.id.ivPreview)
    ImageView ivPreview;
    @BindView(R.id.tvNewsTitle)
    TextView tvNewsTitle;
    @BindView(R.id.tvCreatedAt) TextView tvCreatedAt;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.ivPlay) ImageView ivPlay;


    private Surface surface;
    public VideoItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_news,this,true);
        ButterKnife.bind(this);
        mInstance = MediaPlayerManager.getsInstance(getContext());
        mInstance.addPlaybackListener(this);
          textureView.setSurfaceTextureListener(this);

    }


    @OnClick(R.id.ivPreview)
    public void startPlay() {
        if (surface == null) {
            return;
        }
        mInstance.startPlayer(surface, mPath, mVideoId);

    }
    @OnClick(R.id.textureView)
    public void stopPlayer() {

        mInstance.stopPlayer();
    }
    @OnClick(R.id.tvCreatedAt)
    public void simple() {

        SimpleVideoActivity.open(getContext(),mVideoEntity1);
    }



    @Override
    public void onStartBuffering(String videoId) {


            // 开始缓冲，显示进度条
        if (isCurrentVideo(videoId)) {
            progressBar.setVisibility(View.VISIBLE);}

    }

    @Override
    public void onStopBuffering(String videoId) {

            // 结束缓冲，隐藏进度条
            progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onStartPlay(String videoId) {

            // 开始播放，显示TextureView
        if (isCurrentVideo(videoId)) {
            ivPreview.setVisibility(View.INVISIBLE);
            tvNewsTitle.setVisibility(View.INVISIBLE);
            ivPlay.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);}

    }

    @Override
    public void onStopPlay(String videoId) {

            // 停止播放，显示标题和预览图
        if (isCurrentVideo(videoId)) {
            ivPreview.setVisibility(View.VISIBLE);
            tvNewsTitle.setVisibility(View.VISIBLE);
            ivPlay.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);}

    }

    @Override
    public void onSizeMeasured(String videoId, int width, int height) {

    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.surface = new Surface(surface);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    public void bindData(VideoEntity videoEntity){
        mVideoEntity1 = videoEntity;
        String previewUrl = videoEntity.getPreviewUrl();
         mPath=videoEntity.getVideoUrl();
        tvNewsTitle.setText(videoEntity.getNewsTitle());
        mVideoId = videoEntity.getObjectId();
        Picasso.with(getContext()).load(previewUrl).into(ivPreview);


    }

    private boolean isCurrentVideo(String videoId) {
        if (videoId == null || mVideoEntity1 == null) return false;
        return videoId.equals(mVideoEntity1.getObjectId());
    }

}
