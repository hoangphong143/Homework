package com.example.admins.sqlopenhelper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Admins on 10/10/2017.
 */

public class NoteActivities extends AppCompatActivity {

    private EditText editTitle;
    private EditText editDes;
    private Note note;
    private boolean addMode;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screnn);

        setupUI();
        loadData();

    }

    private void loadData() {


        note = (Note) getIntent().getSerializableExtra(MainActivity.KEY);
        if (note != null) {
            editTitle.setText(note.getTitle());
            editDes.setText(note.getDescription());
            addMode = false;
        } else {
            addMode = true;
        }
    }

    private void setupUI() {
        editTitle = (EditText) findViewById(R.id.et_title);
        editDes = (EditText) findViewById(R.id.et_des);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = editTitle.getText().toString();
        String des = editDes.getText().toString();
        switch (item.getItemId()) {
            case R.id.done: {
                if (TextUtils.isEmpty(title)) {
                    editTitle.setError("Cannot be empty");
                } else if (TextUtils.isEmpty(des)) {
                    editDes.setError("Cannot be empty");
                } else {
                    Note note = new Note(title, des);
                    if (addMode) {
                        DataBaseHelper.getInstance(this).addNote(note);
                        this.finish();
                    } else {
                        note.setId(this.note.getId());

                        DataBaseHelper.getInstance(this).updateNote(note);
                        this.finish();

                    }
                }

                break;

            }


            case R.id.delete: {

                DataBaseHelper.getInstance(this).deleteNote(note);
                this.finish();

                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
