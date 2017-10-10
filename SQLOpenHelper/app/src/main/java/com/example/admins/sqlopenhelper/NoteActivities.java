package com.example.admins.sqlopenhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Admins on 10/10/2017.
 */

public class NoteActivities extends AppCompatActivity {
    private DataBaseHelper db;
    private EditText editTitle;
    private EditText editDes;
    private ImageButton ibSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screnn);

        db = new DataBaseHelper(this);
        setupUI();
        addListener();
    }

    private void addListener() {
        ibSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTitle.getText().toString();
                String description = editDes.getText().toString();

                String notify = null;

                if (TextUtils.isEmpty(title) && TextUtils.isEmpty(description)) {
                    notify = "note empty, don't save!";
                } else {
                    Note note = new Note();
                    note.setTitle(title);
                    note.setDescription(description);
                    if (db.insertNote(note) > 0) {
                        notify = "add success!";
                    } else {
                        notify = "add fail!";
                    }
                }
                Toast.makeText(NoteActivities.this, notify, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void setupUI() {
        editTitle = (EditText) findViewById(R.id.et_title);
        editDes = (EditText) findViewById(R.id.et_des);
        ibSave = (ImageButton) findViewById(R.id.ib_save);

    }

}
