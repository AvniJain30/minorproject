package com.example.minorproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DBname = "Login.db";

    public DBhelper(Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MYdb) {
        MYdb.execSQL("create table users(name TEXT, email TEXT primary key, password TEXT, phoneNo INTEGER)");
        MYdb.execSQL("create table monday(Lecture INTEGER PRIMARY KEY AUTOINCREMENT, Class TEXT, Subject TEXT, Time INTEGER, Room TEXT)");
        MYdb.execSQL("create table tuesday(Lecture INTEGER PRIMARY KEY AUTOINCREMENT, Class TEXT, Subject TEXT, Time INTEGER, Room TEXT)");
        MYdb.execSQL("create table wednesday(Lecture INTEGER PRIMARY KEY AUTOINCREMENT, Class TEXT, Subject TEXT, Time INTEGER, Room TEXT)");
        MYdb.execSQL("create table thursday(Lecture INTEGER PRIMARY KEY AUTOINCREMENT, Class TEXT, Subject TEXT, Time INTEGER, Room TEXT)");
        MYdb.execSQL("create table friday(Lecture INTEGER PRIMARY KEY AUTOINCREMENT, Class TEXT, Subject TEXT, Time INTEGER, Room TEXT)");
        MYdb.execSQL("create table saturday(Lecture INTEGER PRIMARY KEY AUTOINCREMENT, Class TEXT, Subject TEXT, Time INTEGER, Room TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MYdb, int i, int i1) {
        MYdb.execSQL("drop table if exists users");
        MYdb.execSQL("drop table if exists monday");
        MYdb.execSQL("drop table if exists tuesday");
        MYdb.execSQL("drop table if exists wednesday");
        MYdb.execSQL("drop table if exists thursday");
        MYdb.execSQL("drop table if exists friday");
        MYdb.execSQL("drop table if exists saturday");
        onCreate(MYdb);
    }

    public boolean insertDataInUser(String name, String email, String password, String phoneNo){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("phoneNo", phoneNo);
        long result = MYdb.insert("users", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkemail(String email){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        Cursor cursor = MYdb.rawQuery("Select * from users where email = ?", new String[]{email});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkemailPassword(String email, String password){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        Cursor cursor = MYdb.rawQuery("Select * from users where email = ? and password = ?", new String[]{email, password});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean insertDataInMonday(String Lecture, String Class, String Subject, String Time, String Room){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lecture", Lecture);
        contentValues.put("CLass", Class);
        contentValues.put("Subject", Subject);
        contentValues.put("Time", Time);
        contentValues.put("Room", Room);
        long result = MYdb.insert("monday", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertDataInTuesday(String Lecture, String Class, String Subject, String Time, String Room){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lecture", Lecture);
        contentValues.put("CLass", Class);
        contentValues.put("Subject", Subject);
        contentValues.put("Time", Time);
        contentValues.put("Room", Room);
        long result = MYdb.insert("tuesday", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertDataInWednesday(String Lecture, String Class, String Subject, String Time, String Room){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lecture", Lecture);
        contentValues.put("CLass", Class);
        contentValues.put("Subject", Subject);
        contentValues.put("Time", Time);
        contentValues.put("Room", Room);
        long result = MYdb.insert("wednesday", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertDataInThursday(String Lecture, String Class, String Subject, String Time, String Room){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lecture", Lecture);
        contentValues.put("CLass", Class);
        contentValues.put("Subject", Subject);
        contentValues.put("Time", Time);
        contentValues.put("Room", Room);
        long result = MYdb.insert("thursday", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertDataInFriday(String Lecture, String Class, String Subject, String Time, String Room){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lecture", Lecture);
        contentValues.put("CLass", Class);
        contentValues.put("Subject", Subject);
        contentValues.put("Time", Time);
        contentValues.put("Room", Room);
        long result = MYdb.insert("friday", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean insertDataInSaturday(String Lecture, String Class, String Subject, String Time, String Room){
        SQLiteDatabase MYdb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Lecture", Lecture);
        contentValues.put("CLass", Class);
        contentValues.put("Subject", Subject);
        contentValues.put("Time", Time);
        contentValues.put("Room", Room);
        long result = MYdb.insert("saturday", null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor profileView(){
        SQLiteDatabase MYdb = this.getReadableDatabase();
        Cursor cursor = MYdb.rawQuery("Select name, email, phoneNo from users;", null);
        return cursor;
    }

    public Cursor MondayView(){
        SQLiteDatabase MYdb = this.getReadableDatabase();
        Cursor cursor = MYdb.rawQuery("Select Lecture, Class, Subject, Time, Room from monday;", null);
        return cursor;
    }

    public Cursor TuesdayView(){
        SQLiteDatabase MYdb = this.getReadableDatabase();
        Cursor cursor = MYdb.rawQuery("Select Lecture, Class, Subject, Time, Room from tuesday;", null);
        return cursor;
    }

    public Cursor WednesdayView(){
        SQLiteDatabase MYdb = this.getReadableDatabase();
        Cursor cursor = MYdb.rawQuery("Select Lecture, Class, Subject, Time, Room from wednesday;", null);
        return cursor;
    }

    public Cursor ThursdayView(){
        SQLiteDatabase MYdb = this.getReadableDatabase();
        Cursor cursor = MYdb.rawQuery("Select Lecture, Class, Subject, Time, Room from thursday;", null);
        return cursor;
    }

    public Cursor FridayView(){
        SQLiteDatabase MYdb = this.getReadableDatabase();
        Cursor cursor = MYdb.rawQuery("Select Lecture, Class, Subject, Time, Room from friday;", null);
        return cursor;
    }

    public Cursor SaturdayView(){
        SQLiteDatabase MYdb = this.getReadableDatabase();
        Cursor cursor = MYdb.rawQuery("Select Lecture, Class, Subject, Time, Room from saturday;", null);
        return cursor;
    }
}
