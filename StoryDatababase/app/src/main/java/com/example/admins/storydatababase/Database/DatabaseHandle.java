package com.example.admins.storydatababase.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admins on 10/12/2017.
 */

public class DatabaseHandle {
    private static final String TAG = "DatabaseHandle";
    private AssetHelper assetHelper;
    private SQLiteDatabase sqLiteDatabase;

    private DatabaseHandle(Context context) {
        assetHelper =new AssetHelper(context);

    }
    private static DatabaseHandle databaseHandle;
    public static DatabaseHandle getInstance(Context context){
        if(databaseHandle== null){
            databaseHandle= new DatabaseHandle(context);
        }
        return databaseHandle;
    }
    public List<StoryModel> getListStory(){
        List<StoryModel> storyModelList= new ArrayList<>();
        sqLiteDatabase= assetHelper.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from tbl_short_story", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            boolean bookmark = cursor.getInt(6) != 0;

            StoryModel storyModel = new StoryModel(image, title, description,
                    content, author, bookmark);
            storyModelList.add(storyModel);

            cursor.moveToNext();

        }
        Log.d(TAG, "getListStory: " + storyModelList.toString());
        return storyModelList;


    }
    public void setBookmark(StoryModel storyModel, boolean bookmark){
        sqLiteDatabase = assetHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        if(bookmark){
            contentValues.put("bookmark", 1);
        } else  contentValues.put("bookmark", 0);


        sqLiteDatabase.update("tbl_short_story", contentValues, "title= '" + storyModel.getTitle() + "'", null);


    }

}

