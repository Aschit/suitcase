package com.example.suitcase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String db_name="Users.db";

    public DataBaseHelper(@Nullable Context context){
        super(context,"Users.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create table Users (email TEXT Primary Key, password TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if  exists users");

    }
    public boolean insertUsers(String email, String password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        Long Result=sqLiteDatabase.insert("Users",null,contentValues);
        if(Result==-1){
            return false;
        }else {
            return true;

        }

        }







    public boolean CheckEmail(String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where email=?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;

        } else {
            return false;

        }
    }

    public boolean checkEmailPassword(String email,String password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from users where email=? and password=?",new String[]{email,password});
        if (cursor.getCount()>0){
            return true;

        }else{
            return false;

        }
    }





}

