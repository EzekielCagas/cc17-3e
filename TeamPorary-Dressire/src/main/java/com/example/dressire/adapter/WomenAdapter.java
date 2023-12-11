package com.example.dressire.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dressire.DataClass;
import com.example.dressire.R;

import java.util.ArrayList;

public class WomenAdapter extends BaseAdapter {

    private ArrayList<DataClass> dataList;
    private Context context;
    LayoutInflater layoutInflater;

    public WomenAdapter(ArrayList<DataClass> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null){
            view = layoutInflater.inflate(R.layout.grid_item, null);
        }
        ImageView gridImage = view.findViewById(R.id.gridImage);
        TextView gridCaption = view.findViewById(R.id.gridName);
        Glide.with(context).load(dataList.get(i).getImageUrl()).into(gridImage);
        gridCaption.setText(dataList.get(i).getProductName());
        return view;
    }
}
