package com.example.admins.callinguri;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
//    private Button button;
    ListView listView;
    String[] names= {"Tuan","Hieu","Cuong","Phong", "Chau","Nguyen"};
    String[] phones={"0164123","0164124","0164125","0164126","0164127","0164128"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        addListener();


        ViewAdapter viewAdapter = new ViewAdapter(names,phones, this);
        listView.setAdapter(viewAdapter);
    }

    private void addListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" +findViewById(R.id.tv_phone)));

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);

            }
        });

    }

    private void setupUI() {
        listView = (ListView) findViewById(R.id.list_view);
    }


}


