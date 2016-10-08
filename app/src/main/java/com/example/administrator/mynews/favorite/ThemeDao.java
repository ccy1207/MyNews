package com.example.administrator.mynews.favorite;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义数据访问对象，对指定的表进行增删改查操作
 * @author devilwwj
 *
 */
public class ThemeDao {

    private Dao<Theme, Integer> themeDao;
    private DBHelper dbHelper;

    /**
     * 构造方法
     * 获得数据库帮助类实例，通过传入Class对象得到相应的Dao
     * @param context
     */
    public ThemeDao(Context context) {
        try {
            Log.d("ffff"+themeDao, "add:1dbHelper "+ DBHelper.getHelper(context));
            dbHelper = DBHelper.getHelper(context);
            Log.d("dbHelper"+dbHelper, "add:1dbHelper ");
            Dao dao = DBHelper.getHelper(context).getDao(dbHelper);
            Log.d("dbHelper"+dao, "add:Dao 55");
                themeDao =  dao;
            Log.d("ffff"+themeDao, "add: 2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一条记录
     * @param theme
     */
    public void add(Theme theme) {
        try {

            Log.d("ffff"+themeDao, "add: 3"+theme);
            themeDao.create(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除一条记录
     * @param theme
     */
    public void delete(Theme theme) {
        try {
            themeDao.delete(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 更新一条记录
     * @param theme
     */
    public void update(Theme theme) {
        try {
            themeDao.update(theme);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询一条记录
     * @param id
     * @return
     */
    public Theme queryForId(int id) {
        Theme theme = null;
        try {
            theme = themeDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theme;
    }


    /**
     * 查询所有记录
     * @return
     */
    public List<Theme> queryForAll() {
        List<Theme> themes = new ArrayList<Theme>();
        try {
            themes = themeDao.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themes;
    }

public boolean  isContain(String  url){

        List<Theme> themes = queryForAll();
    for (int i = 0; i < themes.size(); i++) {
        Theme theme = themes.get(i);
        String coverUrl = theme.coverUrl;
        if (coverUrl.equals(url)){
            return  true;
        }
    }
    return false;
}
}