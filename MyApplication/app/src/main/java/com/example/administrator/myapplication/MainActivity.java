package com.example.administrator.myapplication;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ScrollingView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fbAdd;
    private ScrollView svView;
    private LinearLayout lnLayout;
    private CustomView customView;
    int image [] = {R.drawable.food_1, R.drawable.food_2, R.drawable.food_3,R.drawable.food_4,R.drawable.food_5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random rd=new Random();
                int i=rd.nextInt(5)+1;
                customView=new CustomView(MainActivity.this);
                customView.setBackgroundResource(image[i]);
                lnLayout.addView(customView);
                svView.fullScroll(View.FOCUS_DOWN);


            }
        });





    }

    private void setupUI() {
        fbAdd= (FloatingActionButton) findViewById(R.id.bt_add);
        svView= (ScrollView) findViewById(R.id.sv_scroll);
        lnLayout= (LinearLayout) findViewById(R.id.ll_lay);

    }

}
