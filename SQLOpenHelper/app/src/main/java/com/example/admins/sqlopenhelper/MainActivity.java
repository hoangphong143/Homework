package com.example.admins.sqlopenhelper;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvNote;
    private FloatingActionButton fbNote;
    private List<Note> noteList = new ArrayList<>();
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        addListener();

    }

    @Override
    protected void onStart() {
        super.onStart();
        noteList = dataBaseHelper.getListNote();

        Adapter adapter = new Adapter(this, R.layout.list_items, noteList);
        lvNote.setAdapter(adapter);

    }

    private void addListener() {
        fbNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoteActivities.class);
                startActivity(intent);
            }
        });
    }

    private void setupUI() {
        lvNote = (ListView) findViewById(R.id.lv_note);
        fbNote = (FloatingActionButton) findViewById(R.id.fb_add);

    }
}


