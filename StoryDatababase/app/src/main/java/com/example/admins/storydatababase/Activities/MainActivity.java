package com.example.admins.storydatababase.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admins.storydatababase.Database.DatabaseHandle;
import com.example.admins.storydatababase.R;
import com.example.admins.storydatababase.Adapter.StoryAdapter;
import com.example.admins.storydatababase.Database.StoryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<StoryModel> storyModelList= new ArrayList<>();
    private ListView lvStory;
    public static final String KEY_STORY="key_story";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvStory= (ListView) findViewById(R.id.lv_story);



        lvStory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent= new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra(KEY_STORY, storyModelList.get(position));
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
    super.onStart();
    storyModelList=DatabaseHandle.getInstance(this).getListStory();
    StoryAdapter storyAdapter= new StoryAdapter(this, R.layout.item_list_story, storyModelList  );
    lvStory.setAdapter(storyAdapter);
}
}
