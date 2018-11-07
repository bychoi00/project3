package com.bychoi00.depositapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "tb_deposit";
    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String RATE = "rate";
    public static final String DEPOSITCASE = "decase";
    public static final String DATE = "date";
    public static final String MONTH_MONEY = "mMoney";
    public static final String TOTAL = "total";
    public static final String MEMO = "memo";
    public static final int DATABASE_VERSION =1;

    public DBHelper(Context context) {
        super(context, "deposit.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            String depositSQL = "CREATE TABLE IF NOT EXISTS " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER primary key autoincrement, "+
                    NAME + " TEXT, " +
                    RATE + " TEXT, " +
                    DEPOSITCASE + " TEXT, " +
                    DATE + " TEXT, " +
                    MONTH_MONEY + " TEXT, " +
                    TOTAL + " TEXT, " +
                    MEMO + " TEXT" +")";
            db.execSQL(depositSQL);
            Log.d("DBCREATE :", "DB가 생성되었습니다.!!!");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            if(newVersion == DATABASE_VERSION){
                db.execSQL("DROP TABLE "+TABLE_NAME);
                onCreate(db);
                Log.d("DBCREATE :", "DB가 업데이트 되었습니다.!!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
