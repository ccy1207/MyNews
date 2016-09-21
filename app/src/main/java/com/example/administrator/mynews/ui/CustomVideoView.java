package com.example.administrator.mynews.ui;

import android.annotation.TargetApi;
import android.content.Context;

import android.media.MediaPlayer;
import android.media.TimedText;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.common.Videolistenter;

import java.io.IOException;



/**
 * Created by Administrator on 2016/9/5.
 */
public class CustomVideoView extends RelativeLayout implements SurfaceHolder.Callback , View.OnClickListener{
  //  String  url="http://o9ve1mre2.bkt.clouddn.com/raw_%E6%B8%A9%E7%BD%91%E7%94%B7%E5%8D%95%E5%86%B3%E8%B5%9B.mp4";

    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;
    public static MediaPlayer mPlayer;
    String  url;
    private Button mStart;
    private Button mStop;
      ProgressBar  mProgressBar;
    TextView  time;
    private float mFloat;

    public CustomVideoView(Context context) {
       this(context,null);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public  void setPath(String s  ){
        url=s;


    }



        public void init(Context context){
            LayoutInflater.from(context).inflate(R.layout.custom_view,this,true);
            mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView);
            mStart = (Button) findViewById(R.id.start);
            mStop = (Button) findViewById(R.id.stop);
            time= (TextView) findViewById(R.id.time);
            mProgressBar= (ProgressBar) findViewById(R.id.video_pg);
            mProgressBar.setProgress(0);
            mStart.setOnClickListener(this);
            mStop.setOnClickListener(this);
            mSurfaceHolder = mSurfaceView.getHolder();
            mSurfaceHolder.addCallback(this);






        }

      public  void  initMediaPlayer(){

          try {

              mPlayer = new MediaPlayer();
              mPlayer.setDisplay(mSurfaceHolder);
              mPlayer.setDataSource(url);
              mPlayer.prepareAsync();
              mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                  @Override
                  public void onPrepared(MediaPlayer mp) {
                      mPlayer.start();
                  }
              });

          } catch (IOException e) {
              e.printStackTrace();
          }


      }




    @Override
    public void surfaceCreated(SurfaceHolder holder) {
      initMediaPlayer();
      new Thread(new Runnable() {
          @Override
          public void run() {



              while (  mPlayer.getDuration()>mPlayer.getCurrentPosition()){
                  float duration = mPlayer.getDuration();
                  float currentPosition = mPlayer.getCurrentPosition();
                       mFloat=currentPosition/duration;
                  mProgressBar.setProgress((int) (mFloat*100));

                  try {
                      Thread.sleep(500);

                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

              }


          }
      }).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }



    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.start:
             mPlayer.start();
                break;
            case R.id.stop:
            mPlayer.pause();
              //  mProgressBar.setProgress(mPlayer.getCurrentPosition());




             //   mProgressBar.setProgress((int) (f*100));

                break;



        }

    }
}
