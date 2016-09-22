package com.example.administrator.mynews.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.TableLayout;

import com.example.administrator.mynews.R;
import com.example.administrator.mynews.adapter.FragmentAdapter;
import com.example.administrator.mynews.adapter.MainTopAdapter;
import com.example.administrator.mynews.common.FragTofa;
import com.example.administrator.mynews.common.RecyclerViewClickListener;
import com.example.administrator.mynews.ui.MainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    ViewPager vp;
    ArrayList<Fragment> mfrag = new ArrayList<>();
    FloatingActionButton mFloat;
    private AdView mAdView;
    private FrameLayout mMfra;
    private TopFragment mFragment;
    private NBAFragment mNBAFragment;
    private CarFragment mCarFragment;
    private JokeFragment mJokeFragment;
    private ImagerFragment mImagerFragment;
    private NawsFragment mObject;
    private TabLayout mLayout;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

         vp= (ViewPager) view.findViewById(R.id.fra_main);
         mLayout= (TabLayout) view.findViewById(R.id.main_table);



         viewpager();
           mFloat= (FloatingActionButton) view.findViewById(R.id.main_float);
           float1();



        mMfra = (FrameLayout) view.findViewById(R.id.fra_main_fra);
        if (mAdView != null) {
            mMfra.removeView(mAdView);
            mAdView.destroy();
        }

        mAdView = new AdView(getActivity());
        mAdView.setAdSize(AdSize.BANNER);
        mAdView.setAdUnitId(getString(R.string.admob_banner_ad_unit_id));
        mMfra.addView(mAdView);

     //   mAdView.loadAd(new AdRequest.Builder().build());

        return  view;

    }




    public void float1(){

        mFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Snackbar.make(v,"hhhh",Snackbar.LENGTH_SHORT).show();
                switch (v.getId()) {
                    case R.id.main_float:
                        switch (vp.getCurrentItem()) {
                            case 0:
                                TopFragment.recy_top.scrollToPosition(0);
                                break;

                            case 1:
                                NBAFragment.recy_nba.scrollToPosition(0);
                                break;

                            case 2:
                                CarFragment.recy_car.scrollToPosition(0);
                                break;

                            case 3:
                                JokeFragment.recy_joke.scrollToPosition(0);
                                break;

                            case 4:
                                ImagerFragment.recy_img.scrollToPosition(0);
                                break;
                            case 5:
                                NawsFragment.recy_news.scrollToPosition(0);
                                break;
                        }
                        break;
                }}
        });
    }


    public void  viewpager(){
        mFragment = new TopFragment();
        mfrag.add(mFragment);
        mNBAFragment = new NBAFragment();
        mfrag.add(mNBAFragment);
        mCarFragment = new CarFragment();
        mfrag.add(mCarFragment);
        mJokeFragment = new JokeFragment();
        mfrag.add(mJokeFragment);
        mImagerFragment = new ImagerFragment();
        mfrag.add(mImagerFragment);
          mObject = new NawsFragment();
        mfrag.add(mObject);
        mfrag.add(new VedioFragment());



        FragmentAdapter adapter = new FragmentAdapter(getChildFragmentManager(), mfrag);

        vp.setAdapter(adapter);
        vp.setCurrentItem(3);


        mLayout.setupWithViewPager(vp);
//        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float offset, int positionOffsetPixels) {
//
//
//            }
//
//
//            @Override
//            public void onPageSelected(int position) {
//              //  vp.setCurrentItem(position);
//}
//
// @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }


}