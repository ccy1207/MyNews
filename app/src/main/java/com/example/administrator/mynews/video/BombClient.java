package com.example.administrator.mynews.video;

import com.example.administrator.mynews.comment.CommentsEntity;
import com.example.administrator.mynews.comment.InQuery;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/9/19.
 */
public class BombClient implements VideoApi{

        private static BombClient sInstance;
    private final Retrofit mRetrofit;

    //单例
    public static synchronized BombClient getInstance(){
        if (sInstance==null){

            sInstance=new BombClient();
        }
        return sInstance;
    }

      private VideoApi mVideoApi;

    private BombClient(){

        // 日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                         .addInterceptor(new BombInterceptor())
                         .addInterceptor(httpLoggingInterceptor)
                .build();
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)

                .baseUrl("https://api.bmob.cn/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();



    }

     public VideoApi getVideoApi(){
         if (mVideoApi==null){
             mVideoApi=mRetrofit.create(VideoApi.class);

         }
         return mVideoApi;

     }

    @Override
    public Call<QueryResult<VideoEntity>> getVideoList(@Query("list") int limit, @Query("skip") int skip) {
        return mVideoApi.getVideoList(limit,skip);
    }

    @Override
    public Call<QueryResult<CommentsEntity>> getComments(@Query("limit") int limit, @Query("skip") int skip, @Query("where") InQuery where) {
        return null;
    }
}
