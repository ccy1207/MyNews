package com.example.administrator.mynews.video;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.adapter.VideoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/12.
 */
public class VideoListView  extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener {

    private VideoListAdapter mAdapter;
    protected VideoApi  mVideoApi;
    public VideoListView(Context context) {
        this(context, null,0);
    }

    public VideoListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public VideoListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.partial_pager_resource,this,true);
        ButterKnife.bind(this);
      //  Log.d("hhhhhhhhhhh", "initViewlist: ");
        mVideoApi=BombClient.getInstance().getVideoApi();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new VideoListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(this);

    }

    public void atuoRefresh(){
        Log.d("shuju", "onResponse:onRefresh ");
        mRefreshLayout.setRefreshing(true);
        onRefresh();

        }

    @Override
    public void onRefresh() {
         //获取数据

        Call<QueryResult<VideoEntity>> call=BombClient.getInstance().getVideoList(5,0);

         if (call==null){

             mRefreshLayout.setRefreshing(false);
                 return;
         }

        call.enqueue(new Callback<QueryResult<VideoEntity>>() {
            @Override
            public void onResponse(Call<QueryResult<VideoEntity>> call, Response<QueryResult<VideoEntity>> response) {

                mRefreshLayout.setRefreshing(false);

                List<VideoEntity> datas= response.body().getResults();
                mAdapter.clear();
                mAdapter.addData(datas);


            }

            @Override
            public void onFailure(Call<QueryResult<VideoEntity>> call, Throwable t) {


            }
        });

    }





}
