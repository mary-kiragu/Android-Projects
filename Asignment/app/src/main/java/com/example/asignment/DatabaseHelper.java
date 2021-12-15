package com.example.asignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){

        super(context, "UserDatabase.db" , null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create Table Userdetails(username TEXT primary key, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop Table if exists Userdetails");

    }

    // CRUD operations
    public Boolean insertuserdata(String username, String password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("username", username);
        values.put("password", password);
        long result= sqLiteDatabase.insert("userdetails", null, values);
        if(result== -1){
            return false;
        }
        else return true;

    }
    public Cursor getdata(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery("Select * from Userdetails", null);
        return cursor;


    }



}
