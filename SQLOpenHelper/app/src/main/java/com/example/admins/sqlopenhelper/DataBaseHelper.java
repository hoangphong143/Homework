package com.example.admins.sqlopenhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Admins on 10/9/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "note.db";
    public static final int DATA_VERSION = 1;

    public static final String TABLE_NOTE = "tb_note";
    public static final String KEY_ID_NOTE = "id";
    public static final String KEY_TITLE_NOTE = "title";
    public static final String KEY_DESCRIPTION_NOTE = "description";

    public static final String CREAT_TABLE_NOTE = "CREATE TABLE " + TABLE_NOTE + "(" +
            KEY_ID_NOTE + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
            ", " + KEY_TITLE_NOTE + " TEXT NOT NULL" +
            "," + KEY_DESCRIPTION_NOTE + " TEXT NOT NULL" +
            ")";
    private static final String TAG = DataBaseHelper.class.toString();

    private SQLiteDatabase db;
    public static DataBaseHelper dataBaseHelper;
    public static DataBaseHelper getInstance(Context context) {
        if (dataBaseHelper == null) {
            dataBaseHelper = new DataBaseHelper(context);
        }
        return dataBaseHelper;
    }
    public DataBaseHelper(Context context) {
        super(context, Database_Name, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            // tao database
            db.execSQL(CREAT_TABLE_NOTE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void deleteNote(Note note){
        db=getWritableDatabase();
        db.delete(TABLE_NOTE,KEY_TITLE_NOTE +"=?",new String[]{note.getTitle()});
        db.close();

    }
    public void updateNote(Note note){
        db=getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(KEY_DESCRIPTION_NOTE, note.getDescription());
        contentValues.put(KEY_TITLE_NOTE, note.getTitle());
        db.update(TABLE_NOTE,contentValues,"id=" + note.getId() + "", null);
        db.close();

    }

    public void open() {
        try {
            db = getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void close() {
        if (db != null && db.isOpen()) {
            try {
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }




    public ArrayList<Note> getListNote() {
        ArrayList<Note> list = new ArrayList<>();
        open();
        Cursor cursor = db.rawQuery("select * from tb_note", null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Note note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID_NOTE)));
                note.setTitle(cursor.getString(cursor.getColumnIndex(KEY_TITLE_NOTE)));
                note.setDescription(cursor.getString(cursor.getColumnIndex(KEY_DESCRIPTION_NOTE)));
                Log.d(TAG, "getListNote: "+note.getId());

                list.add(note);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return list;
    }

    public long addNote (Note note) {
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE_NOTE, note.getTitle());
        values.put(KEY_DESCRIPTION_NOTE, note.getDescription());
        long index = db.insert(TABLE_NOTE, null, values);
        close();
        return index;

    }
}
