package com.example.administrator.mynews.comment;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.video.VideoEntity;
import com.example.videoplayer.list.MediaPlayerManager;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/20.
 */
public class CommentItemView extends FrameLayout implements
        MediaPlayerManager.OnPlaybackListener,
        TextureView.SurfaceTextureListener {
    @BindView(R.id.tvAuthor)
    TextView mTvAuthor;
    @BindView(R.id.tvContent)
    TextView mTvContent;
    @BindView(R.id.tvCreatedAt)
    TextView  mTvCreatedAt;
    private MediaPlayerManager mInstance;
    private CommentsEntity mCommentsEntity1;


    public CommentItemView(Context context) {
        this(context, null, 0);
    }

    public CommentItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }


    public CommentItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_comments, this, true);
        ButterKnife.bind(this);


    }


    @Override
    public void onStartBuffering(String videoId) {


    }

    @Override
    public void onStopBuffering(String videoId) {


    }

    @Override
    public void onStartPlay(String videoId) {

        // 开始播放，显示TextureView

    }

    @Override
    public void onStopPlay(String videoId) {

        // 停止播放，显示标题和预览图

    }

    @Override
    public void onSizeMeasured(String videoId, int width, int height) {

    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {

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

    public void bindData(CommentsEntity commentsEntity) {
        mCommentsEntity1 = commentsEntity;

         mTvContent.setText(commentsEntity.getContent());
        mTvAuthor.setText(commentsEntity.getAuthor().getUsername());

        mTvCreatedAt.setText(commentsEntity.getCreatedAt().toString());

    }

    private boolean isCurrentVideo(String videoId) {
        if (videoId == null || mCommentsEntity1 == null) return false;
        return videoId.equals(mCommentsEntity1.getCreatedAt());
    }

}
