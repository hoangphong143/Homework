package com.example.admins.sqlopenhelper;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admins on 10/10/2017.
 */

public class Adapter extends ArrayAdapter<Note> {
    private List<Note> noteList;
    private Context context;
    private int resource;

    public Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Note> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.noteList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        convertView=layoutInflater.inflate(resource, parent, false);

        TextView tvTitle= convertView.findViewById(R.id.tv_title);
        TextView tvDes= convertView.findViewById(R.id.tv_des);

        tvTitle.setText(noteList.get(position).getTitle());
        tvDes.setText(noteList.get(position).getDescription());
        return convertView;
    }
}
