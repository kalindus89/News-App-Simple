package com.newsapp.simple;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.newsapp.simple.fragments.EntertainmentFragment;
import com.newsapp.simple.fragments.HealthFragment;
import com.newsapp.simple.fragments.HomeFragment;
import com.newsapp.simple.fragments.ScienceFragment;
import com.newsapp.simple.fragments.SportsFragment;
import com.newsapp.simple.fragments.TechnologyFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount =behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new HomeFragment();
            case 1:
                return  new SportsFragment();
            case 2:
                return  new HealthFragment();
            case 3:
                return  new ScienceFragment();
            case 4:
                return  new EntertainmentFragment();
            case 5:
                return  new TechnologyFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
