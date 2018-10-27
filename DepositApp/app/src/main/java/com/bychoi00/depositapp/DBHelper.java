package com.bychoi00.depositapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;

    public DBHelper(Context context) {
        super(context, "depositdb", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            String depositSQL = "CREATE TABLE tb_deposit IF NOT EXISTS"+
                    "(_id integer primary key autoincrement," +
                    "NAME TEXT,"+
                    "RATE TEXT,"+
                    "DEPOSIT_CASE TEXT,"+
                    "DATE TEXT,"+
                    "MONTH_MONEY TEXT,"+
                    "TOTAL TEXT,"+
                    "MEMO TEXT)";
            db.execSQL(depositSQL);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            if(newVersion == DATABASE_VERSION){
                db.execSQL("DROP TABLE tb_deposit");
                onCreate(db);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
