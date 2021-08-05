package com.newsapp.simple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mHome, msScience, mHealth, mTech, mEntertainment,mSports;
    Toolbar mToolbar;
    PagerAdapter pagerAdapter;

    // get from newsapi.com
    String api ="6fa171f4d05742f6bd1cb246539f50ad";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolBar);
        setSupportActionBar(mToolbar);

        mHome=findViewById(R.id.home);
        msScience=findViewById(R.id.science);
        mHealth=findViewById(R.id.health);
        mTech=findViewById(R.id.technology);
        mEntertainment=findViewById(R.id.entertainment);
        mSports=findViewById(R.id.sports);

        ViewPager viewPager =findViewById(R.id.fragmentContainer);
        tabLayout=findViewById(R.id.include);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        //for change fragment by selecting tabs
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //for swiping to change fragment
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}