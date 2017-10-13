package com.example.admins.storydatababase.Activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admins.storydatababase.Database.DatabaseHandle;
import com.example.admins.storydatababase.Database.StoryModel;
import com.example.admins.storydatababase.R;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView ivBack;
    private ImageView ivBookmark;
    private ImageView ivStory;
    private TextView tvTitle;
    private TextView tvAuthor;
    private TextView tvDescription;
    private Button btStartReading;

    private StoryModel storymodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        setupUI();
        loadData();
    }

    private void loadData() {
        storymodel= (StoryModel) getIntent().getSerializableExtra(MainActivity.KEY_STORY);
        String[] base64 = storymodel.getImage().split(",");


        byte[] bytesFromBase64 = Base64.decode(base64[1], Base64.DEFAULT);


        Bitmap bitmap = BitmapFactory.decodeByteArray(bytesFromBase64, 0, bytesFromBase64.length);
        ivStory.setImageBitmap(bitmap);
        tvAuthor.setText(storymodel.getAuthor());
        tvDescription.setText(storymodel.getDescription());
        tvTitle.setText(storymodel.getTitle());

        if(storymodel.isBookmark()) {
            ivBookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
        } else
        {ivBookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);

        }

    }

    private void setupUI() {
        ivBack = (ImageView) findViewById(R.id.iv_back);
        ivBookmark = (ImageView) findViewById(R.id.iv_bookmark);
        ivStory = (ImageView) findViewById(R.id.iv_story);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvAuthor = (TextView) findViewById(R.id.tv_author);
        tvDescription = (TextView) findViewById(R.id.tv_des);
        btStartReading = (Button) findViewById(R.id.bt_start_reading);

        ivBack.setOnClickListener(this);
        ivBookmark.setOnClickListener(this);
        btStartReading.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_start_reading:{
                break;
            }
            case R.id.iv_back: {
                super.onBackPressed();
                break;
            }
            case R.id.iv_bookmark:{
                setBookmark();
                break;
            }
        }

    }

    private void setBookmark() {
        if (storymodel.isBookmark()) {
            ivBookmark.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
            DatabaseHandle.getInstance(this).setBookmark(storymodel, false);


        } else {
            ivBookmark.setImageResource(R.drawable.ic_bookmark_black_24dp);
            DatabaseHandle.getInstance(this).setBookmark(storymodel, true);




        }}
}
