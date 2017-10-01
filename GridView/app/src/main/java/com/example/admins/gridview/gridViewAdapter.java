package com.example.admins.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admins on 10/2/2017.
 */

public class gridViewAdapter extends BaseAdapter{
    private Context context;
    private String[] tenLogo;
    private int[] inLogo;

    public gridViewAdapter(Context context, String[] tenLogo, int[] inLogo) {
        this.context = context;
        this.tenLogo = tenLogo;
        this.inLogo = inLogo;
    }

    @Override
    public int getCount() {
        return tenLogo.length;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.gridview,null);
        TextView textView = (TextView) view.findViewById(R.id.txtLogo);
        ImageView imageView =  (ImageView)view.findViewById(R.id.ImgView);

        textView.setText(tenLogo[i]);
        imageView.setImageResource(inLogo[i]);

        return view;
}}
