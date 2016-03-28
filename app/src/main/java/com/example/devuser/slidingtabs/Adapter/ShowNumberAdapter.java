package com.example.devuser.slidingtabs.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.devuser.slidingtabs.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devuser on 28-03-2016.
 */
public class ShowNumberAdapter extends ArrayAdapter {
    Context context ;
 List<Integer> numlist = new ArrayList<>();;
    public ShowNumberAdapter(Context context, int resource, List numlist) {
        super(context, resource, numlist);
        this.context = context ;
        this.numlist = numlist ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.row_list_fragment,parent,false);

        TextView textview_main_num = (TextView)convertView.findViewById(R.id.textview_row_data);

        textview_main_num.setText(numlist.get(position)+"");

        return convertView;
    }
}
