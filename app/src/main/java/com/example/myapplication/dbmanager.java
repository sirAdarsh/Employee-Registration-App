package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.SQLData;

public class dbmanager extends SQLiteOpenHelper {

    private static final String dbname = "dbdetails";

    public dbmanager(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "create table tbl_detail ( id integer primary key autoincrement, name text, email text, address text, doj text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry = "DROP TABLE IF EXISTS tbl_detail";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }

    public String addrecord(String name, String email, String address, String doj){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("address", address);
        cv.put("doj", doj);
        cv.put("email", email);
        float res = db.insert("tbl_detail", null, cv);
        if(res==-1){
            return "Failed";
        }
        else{
            return "Succesfully inserted";
        }
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "SELECT * from tbl_detail order by id desc";
        Cursor cursor = db.rawQuery(qry, null);
        return cursor;
    }

}
