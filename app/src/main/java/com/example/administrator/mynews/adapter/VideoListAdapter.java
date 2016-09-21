package com.example.administrator.mynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.video.VideoEntity;
import com.example.administrator.mynews.video.VideoItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.MyViewHolder>{
       Context mContext;
         ArrayList<VideoEntity> mList=new ArrayList<>();

      public final void clear(){
          mList.clear();
          notifyDataSetChanged();

      }
    public  final void addData(List<VideoEntity> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }


    public VideoListAdapter(Context context) {
        mContext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            VideoItemView itemView=new VideoItemView(parent.getContext());

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VideoEntity entity = mList.get(position);
        holder.mItemView.bindData(entity);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
          VideoItemView  mItemView;
        public MyViewHolder(View itemView) {
            super(itemView);
           mItemView= (VideoItemView) itemView;

        }
    }
}
