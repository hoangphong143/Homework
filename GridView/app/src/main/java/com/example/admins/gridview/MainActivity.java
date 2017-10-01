package com.example.admins.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    String[] ten = {"hinh1","hinh2","hinh3","hinh4","hinh5","hinh6","hinh7","hinh8","hinh9","hinh10"};
    int[] hinh = {R.drawable.anh_1,R.drawable.anh_2,R.drawable.anh_3,R.drawable.anh_4,R.drawable.anh_5,R.drawable.anh_6,
            R.drawable.anh_7,R.drawable.anh_8,R.drawable.anh_9,R.drawable.anh_10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inItView();
       gridViewAdapter gridViewAdapter = new gridViewAdapter(this,ten,hinh);
        gridView.setAdapter(gridViewAdapter);
    }

    private void inItView() {
        gridView = (GridView) findViewById(R.id.gridView);
    }

}
