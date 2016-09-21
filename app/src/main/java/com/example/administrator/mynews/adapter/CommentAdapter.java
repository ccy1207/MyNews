package com.example.administrator.mynews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mynews.comment.CommentItemView;
import com.example.administrator.mynews.comment.CommentsEntity;
import com.example.administrator.mynews.video.VideoEntity;
import com.example.administrator.mynews.video.VideoItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    Context mContext;
    ArrayList<CommentsEntity> mList=new ArrayList<>();

    public final void clear(){
        mList.clear();
        notifyDataSetChanged();

    }
    public  final void addData(List<CommentsEntity> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }


    public CommentAdapter(Context context) {
        mContext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommentItemView itemView=new CommentItemView(parent.getContext());

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CommentsEntity entity = mList.get(position);
        holder.mItemView.bindData(entity);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder{
        CommentItemView mItemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mItemView= (CommentItemView) itemView;

        }
    }
}
