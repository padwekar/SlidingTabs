package com.example.devuser.slidingtabs.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.devuser.slidingtabs.Adapter.ShowNumberAdapter;
import com.example.devuser.slidingtabs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devuser on 07-03-2016.
 */
public class ThirdFragment extends Fragment{
    ListView listView ;
    ArrayList<Integer> nextInt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        nextInt = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_third,container,false);
        listView = (ListView) view.findViewById(R.id.next_frag_list);
        nextInt = getArguments().getIntegerArrayList("numlist");
        ShowNumberAdapter showNumberAdapter = new ShowNumberAdapter(getContext(),R.layout.activity_main,nextInt);
        listView.setAdapter(showNumberAdapter);
        return view;
    }
}
