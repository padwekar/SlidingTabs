package com.example.devuser.slidingtabs.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
public class FirstFragment extends Fragment {
    ListView listView ;
    List<Integer> prevInt = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first,container,false);
        listView = (ListView) view.findViewById(R.id.prev_frag_list);
        prevInt = getArguments().getIntegerArrayList("numlist");
        ShowNumberAdapter showNumberAdapter = new ShowNumberAdapter(getContext(),R.layout.activity_main,prevInt);
        listView.setAdapter(showNumberAdapter);
        return view;
    }
}
