package com.example.administrator.mynews.common;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/8/8.
 */
@DatabaseTable()
public class TopInfo implements Serializable {

    public String  img;
    public    String  text;
    public    String  ptime;
    public    String  sou;
    public   String   url;
    public TopInfo(String i, String t){
        img=i;
        text=t;


    }
    public TopInfo(String i, String t, String p, String s, String   u){
        img=i;
        text=t;
       ptime=p;
        sou=s;
        url=u;
    }

    public TopInfo(String i, String t, String p, String s){
        img=i;
        text=t;
        ptime=p;
        sou=s;

    }

    public TopInfo(String i, String t, String u){
        img=i;
        text=t;

        url=u;

    }

      @DatabaseField(id = true)
      private  int id;
    @DatabaseField(columnName = "NAME")
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    private static List<TopInfo> topGSONs;

    public static List<TopInfo> getTopGSONs(Context context) {
        if (topGSONs != null) {
            return topGSONs;
        }

        try {
            InputStream inputStream = context.getAssets().open("topgaon.json");

            String content = IOUtils.toString(inputStream);
            Gson gson = new Gson();
            topGSONs = gson.fromJson(content, new TypeToken<List<TopInfo>>() {
            }.getType());
            return topGSONs;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }
