package com.example.admins.sqlopenhelper;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvNote;
    private FloatingActionButton fbNote;
    public static String KEY="KEY";
    private List<Note>noteList= new ArrayList<>();



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
        noteList= DataBaseHelper.getInstance(MainActivity.this).getListNote();

        Adapter adapter = new Adapter(this, R.layout.list_items, noteList );
        lvNote.setAdapter(adapter);
        lvNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(MainActivity.this, NoteActivities.class);
                intent.putExtra(KEY, noteList.get(position));
                startActivity(intent);
            }
        });

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


