package com.example.administrator.mynews.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.adapter.TopAdapter;
import com.example.administrator.mynews.common.TopInfo;
import com.example.administrator.mynews.favorite.Theme;
import com.example.administrator.mynews.favorite.ThemeDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavoriteActivity extends AppCompatActivity {


    @BindView(R.id.favorite)
    RecyclerView recy;
    @BindView(R.id.favorite_tb)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);

        recy.setLayoutManager(manager);

        ThemeDao themeDao=new ThemeDao(this);
        List<Theme> themes = themeDao.queryForAll();
          ArrayList<TopInfo> list=new ArrayList<>();

        for (int i = 0; i < themes.size(); i++) {
            Theme theme = themes.get(i);
                    theme.getCoverUrl();
           list.add(new TopInfo(theme.getCoverId(),theme.getTitle(),theme.getCoverUrl()));
        }


        recy.setAdapter(new TopAdapter(this,list));


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this).unbind();
    }
}
