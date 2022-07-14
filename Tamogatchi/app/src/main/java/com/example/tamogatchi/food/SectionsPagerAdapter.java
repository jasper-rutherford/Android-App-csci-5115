package com.example.tamogatchi.food;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tamogatchi.food.AddFoodFragment;
import com.example.tamogatchi.food.MyFoodFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;
    private final Context mContext;
    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return MyFoodFragment.newInstance(0);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return AddFoodFragment.newInstance(1);
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return "Buy Food";
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return "Owned Food";
            default:
                return null;
        }
    }
}
