package com.example.devuser.slidingtabs.Activities;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.devuser.slidingtabs.Adapter.PagerAdapter;
import com.example.devuser.slidingtabs.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    TextView textview_number ;
    Fragment firstFragment , secondFragment , thirdFragment ;
    ArrayList<Integer> prevNumList , currentNumList , nextNumList ;
    FragmentManager fragmentManager ;
    FragmentTransaction fragmentTransaction ;
    PagerAdapter adapter;
    ViewPager viewPager;
    int position = 0;
    int tabPos ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview_number = (TextView)findViewById(R.id.textview_number);
        textview_number.setText(position+"");
        prevNumList = new ArrayList<>();
        currentNumList = new ArrayList<>();
        nextNumList = new ArrayList<>();
        fragmentManager =getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        //Tab
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("PREV"));
        tabLayout.addTab(tabLayout.newTab().setText("NOW"));
        tabLayout.addTab(tabLayout.newTab().setText("NEXT"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Pager Adapter
        adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());


        //View Pager
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(adapter);
        tabPos = viewPager.getCurrentItem();


        findViewById(R.id.btn_prev).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                textview_number.setText(position+"");
                setList(position);
                adapter.notifyDataSetChanged();

            }
        });

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                textview_number.setText(position+"");
                setList(position);
                adapter.notifyDataSetChanged();


            }
        });
        //Toolbar
      /*  Toolbar toolbar = (Toolbar)findViewById(R.id.tab_layout);
        setSupportActionBar(toolbar);
*/

        
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tabPos = viewPager.getCurrentItem();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void setList(int position) {
        prevNumList = new ArrayList<>();
        currentNumList = new ArrayList<>();
        nextNumList = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            prevNumList.add(position-1);
            currentNumList.add(position);
            nextNumList.add(position + 1);
        }
        adapter.setSuperLists(prevNumList,currentNumList,nextNumList);

        viewPager.setCurrentItem(tabPos);

    }


 /*   setFragmentValues() {
        firstFragment = new Fragment();
        Bundle bundleFirst = new Bundle();
        bundleFirst.putIntegerArrayList("numlist",prevNumList);
        firstFragment.setArguments(bundleFirst);

        secondFragment = new Fragment();
        Bundle bundleSecond = new Bundle();
        bundleFirst.putIntegerArrayList("numlist", currentNumList);
        secondFragment.setArguments(bundleFirst);


        thirdFragment = new Fragment();
        Bundle bundleThird = new Bundle();
        bundleFirst.putIntegerArrayList("numlist",nextNumList);
        thirdFragment.setArguments(bundleFirst);

    }
*/
}





