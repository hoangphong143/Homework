package com.example.admins.storydatababase.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admins.storydatababase.Database.StoryModel;
import com.example.admins.storydatababase.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admins on 10/12/2017.
 */

public class StoryAdapter extends ArrayAdapter{
    private Context context;
    private int resource;
    private List<StoryModel> storyModels;
    private View vbookmark;

    public StoryAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.storyModels = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        convertView= layoutInflater.inflate(resource,parent, false);

        vbookmark= convertView.findViewById(R.id.v_bookmark);

        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvAuthor = convertView.findViewById(R.id.tv_author);
        ImageView imageView = convertView.findViewById(R.id.iv_story);

        tvTitle.setText(storyModels.get(position).getTitle());
        tvAuthor.setText(storyModels.get(position).getAuthor());

        //set data
        tvTitle.setText(storyModels.get(position).getTitle());
        tvAuthor.setText(storyModels.get(position).getAuthor());

        //tách chuỗi ra thành 2 phần (ngăn cách bởi dấu ","; phần sau là phần base64 mà ta cần dùng để decode ra ảnh
        String[] base64 = storyModels.get(position).getImage().split(",");

        //decode từ base64 ra byte[]
        byte[] bytesFromBase64 = Base64.decode(base64[1], Base64.DEFAULT);

        //decode từ byte[] ra bitmap
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytesFromBase64, 0, bytesFromBase64.length);

        imageView.setImageBitmap(bitmap);
        if (storyModels.get(position).isBookmark()) {
            vbookmark.setBackgroundResource(R.color.colorAccent);
        } else {
            vbookmark.setBackgroundResource(R.color.colorPrimary);
        }


        return convertView;
    }
}
