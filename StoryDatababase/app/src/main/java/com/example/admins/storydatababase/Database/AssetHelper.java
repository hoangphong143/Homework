package com.example.admins.storydatababase.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Admins on 10/12/2017.
 */

public class AssetHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "short_story.db";
    private static final int DATABASE_VERSION = 1;

    public AssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
