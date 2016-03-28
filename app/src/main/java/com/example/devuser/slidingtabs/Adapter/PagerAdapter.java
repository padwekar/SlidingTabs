package com.example.devuser.slidingtabs.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.devuser.slidingtabs.Fragments.FirstFragment;
import com.example.devuser.slidingtabs.Fragments.SecondFragment;
import com.example.devuser.slidingtabs.Fragments.ThirdFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by devuser on 07-03-2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int noOfTabs;
    ArrayList<Integer> prevList, currList,nextList ;
    Integer[] nums = {1,2,3,4,5};
    public PagerAdapter(FragmentManager fm ,int noOfTabs) {
        super(fm);
        prevList = new ArrayList<>();
        currList = new ArrayList<>();
        nextList = new ArrayList<>();
        this.noOfTabs = noOfTabs ;
    }

    public void setSuperLists(ArrayList<Integer> prevList,ArrayList<Integer> currList,ArrayList<Integer> nextList){
        this.prevList = prevList ;
        this.currList = currList ;
        this.nextList = nextList ;
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
            return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                FirstFragment firstFragment = new FirstFragment();
                Bundle bundleFirst = new Bundle();
                bundleFirst.putIntegerArrayList("numlist", prevList);
                firstFragment.setArguments(bundleFirst);
                return  firstFragment ;

            case 1 :
                SecondFragment secondFragment = new SecondFragment();
                Bundle bundleSecond = new Bundle();
                bundleSecond.putIntegerArrayList("numlist", currList);
                secondFragment.setArguments(bundleSecond);
                return  secondFragment ;

            case 2 :
                ThirdFragment thirdFragment = new ThirdFragment();
                Bundle bundleThird = new Bundle();
                bundleThird.putIntegerArrayList("numlist",nextList);
                thirdFragment.setArguments(bundleThird);
                return thirdFragment;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }


}
