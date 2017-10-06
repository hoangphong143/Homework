package com.example.admins.callinguri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Admins on 10/6/2017.
 */

public class ViewAdapter extends BaseAdapter {
    private String[] ten;
    private String[] phone;




    private Context context;

    public ViewAdapter(String[] ten, String[] phone, Context context) {
        this.ten = ten;
        this.phone = phone;
        this.context = context;
    }

    @Override
    public int getCount() {
        return ten.length;
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
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= inflater.inflate(R.layout.listview, null);
        TextView textView=(TextView)view.findViewById(R.id.tv_name);
        TextView textView1=(TextView)view.findViewById(R.id.tv_phone);
        textView.setText(ten[i]);
        textView1.setText(phone[i]);
        return view;



    }
}
