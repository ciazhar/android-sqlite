package com.ciazhar.sqlitedatabaseexample;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by D2J-00 on 15/11/2017.
 */
public class DatabaseConfig extends SQLiteOpenHelper {

    static final private String DB_NAME = "Educations";
    static final private String DB_TABLE = "students";
    static final private int DB_VER = 1;

    Context context;
    SQLiteDatabase database;

    public DatabaseConfig(Context context) {
        super(context,DB_NAME,null,DB_VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DB_TABLE+" (_id integer primary key autoincrement,stu_name text,collage_name text);");
        Log.i("Database","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exixts "+DB_TABLE);
        onCreate(db);
    }

    public void insertData(String name, String collage){
        database = getWritableDatabase();

        database.execSQL("insert into "+DB_TABLE+" (stu_name,collage_name) values('"+name+"','"+collage+"');");
        Toast.makeText(context,"Data saved succesfully",Toast.LENGTH_LONG).show();
    }

    public void getAll(){
        database = getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from "+DB_TABLE,null);
        StringBuilder builder = new StringBuilder();

        while (cursor.moveToNext()){
            String nama = cursor.getString(1);
            String collage= cursor.getString(2);
            builder.append(nama+"     "+collage+"\n");
        }
        Toast.makeText(context,builder.toString(),Toast.LENGTH_LONG).show();
    }
}
