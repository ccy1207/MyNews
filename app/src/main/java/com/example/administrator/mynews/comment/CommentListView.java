package com.example.administrator.mynews.comment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.adapter.CommentAdapter;
import com.example.administrator.mynews.adapter.VideoListAdapter;
import com.example.administrator.mynews.video.BombClient;
import com.example.administrator.mynews.video.BombConst;
import com.example.administrator.mynews.video.QueryResult;
import com.example.administrator.mynews.video.VideoApi;
import com.example.administrator.mynews.video.VideoEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/20.
 */
public class CommentListView extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener {

    private String mNewsId1;

    public CommentListView(Context context) {
        this(context, null, 0);

    }

    public CommentListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private CommentAdapter mAdapter;
    protected VideoApi mVideoApi;
    ArrayList<String> mlist=new ArrayList<>();
    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.partial_pager_resource, this, true);
        ButterKnife.bind(this);

        mVideoApi = BombClient.getInstance().getVideoApi();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CommentAdapter(getContext());

        mRecyclerView.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(this);
    }
    public void atuoRefresh(){
       // Log.d("shuju", "onResponse:onRefresh ");
        mRefreshLayout.setRefreshing(true);
        onRefresh();

    }
      public void setNewsId(String newsId){
          mNewsId1 = newsId;

      }

     public  List<String> getComment(){

          return  mlist;
     }

    @Override
    public void onRefresh() {
        InQuery where = new InQuery(BombConst.FIELD_NEWS, BombConst.TABLE_NEWS,mNewsId1);
        Call<QueryResult<CommentsEntity>> call = mVideoApi.getComments(20, 0, where);


        if (call==null){

            mRefreshLayout.setRefreshing(false);
            return;
        }
       call.enqueue(new Callback<QueryResult<CommentsEntity>>() {
           @Override
           public void onResponse(Call<QueryResult<CommentsEntity>> call, Response<QueryResult<CommentsEntity>> response) {
               List<CommentsEntity> list = response.body().getResults();
               for (int i = 0; i < list.size(); i++) {
                   CommentsEntity commentsEntity = list.get(i);
                      mlist.add(commentsEntity.getContent());

               }
             mListenter.setData(mlist);
               mAdapter.addData(list);



           }

           @Override
           public void onFailure(Call<QueryResult<CommentsEntity>> call, Throwable t) {

           }
       });


    }
    private  CommentListenter  mListenter;

    public  void setCommentListenter(CommentListenter listenter){
        mListenter=listenter;
    }

    public  interface CommentListenter{

        void  setData( ArrayList<String> mlist);
    }
}