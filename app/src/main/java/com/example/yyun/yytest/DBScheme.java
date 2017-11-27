package com.example.yyun.yytest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yyun on 2017/11/27.
 */

public class DBScheme extends SQLiteOpenHelper {
    public DBScheme(Context context) {
        super(context, "yyun.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table testtable(_id integer primary key autoincrement,uid integer,contextdata varchar,createtime varchar,changetime varchar,gps varchar,status varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
