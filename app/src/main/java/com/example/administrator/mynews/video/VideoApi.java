package com.example.administrator.mynews.video;

import com.example.administrator.mynews.comment.CommentsEntity;
import com.example.administrator.mynews.comment.InQuery;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/9/19.
 */
public interface VideoApi {

    /**
     * 获取所有的视频新闻列表
     */

    @GET("1/classes/News?order=-createdAt")
    Call<QueryResult<VideoEntity>> getVideoList(@Query("list")int limit, @Query("skip")int skip);
    /** 获取评论*/
    @GET("1/classes/Comments?include=author&order=-createdAt")
    Call<QueryResult<CommentsEntity>> getComments(
            @Query("limit") int limit,
            @Query("skip") int skip,
            @Query("where") InQuery where);


}
