package com.bychoi00.depositapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

    public static final int DATABASE_VERSION = 1;

    public List Items;


    public DBHelper(Context context) {
        super(context, "deposit.db", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String depositSQL = "CREATE TABLE IF NOT EXISTS " +
                    TABLE_NAME + " (" +
                    _ID + " INTEGER primary key autoincrement, " +
                    NAME + " TEXT, " +
                    RATE + " TEXT, " +
                    DEPOSITCASE + " TEXT, " +
                    DATE + " TEXT, " +
                    MONTH_MONEY + " TEXT, " +
                    TOTAL + " TEXT, " +
                    MEMO + " TEXT" + ")";
            db.execSQL(depositSQL);
            Log.d("DBCREATE :", "DB가 생성되었습니다.!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            if (newVersion == DATABASE_VERSION) {
                db.execSQL("DROP TABLE " + TABLE_NAME);
                onCreate(db);
                Log.d("DBCREATE :", "DB가 업데이트 되었습니다.!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addItem(RecyclerItem recyclerItem) {
        SQLiteDatabase db = getWritableDatabase();

        // 2. Person Data를 Insert한다.
        // _id는 자동으로 증가하기 때문에 넣지 않습니다.
        StringBuffer sb = new StringBuffer();
        sb.append(" INSERT INTO " + TABLE_NAME + " ( ");
        sb.append(NAME + ", " + RATE + ", " + DEPOSITCASE + ", " + DATE + ", " + MONTH_MONEY + ", " + TOTAL + ", " + MEMO);
        sb.append(" VALUES ( ?, ?, ?, ?, ?, ?, ? ) ");

        db.execSQL(sb.toString(),
                new Object[]{recyclerItem.getName(), recyclerItem.getRate(), recyclerItem.getDecase(),
                        recyclerItem.getDudate(), recyclerItem.getMmoney(), recyclerItem.getTotal(), recyclerItem.getMemo()});

    }

    public List getAllData() {
        //DB에 추가
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery("select * from tb_deposit", null);
        int count = cursor.getCount();

        Items = new ArrayList();
        Items.clear();
        RecyclerItem recyclerItem = null;

        for (int i = 0; i < count; i++) {
            recyclerItem = new RecyclerItem();

            cursor.moveToNext();
            recyclerItem.set_Id(cursor.getString(0));
            recyclerItem.setName(cursor.getString(1));
            recyclerItem.setRate(cursor.getString(2));
            recyclerItem.setDecase(cursor.getString(3));
            recyclerItem.setDudate(cursor.getString(4));
            recyclerItem.setMmoney(cursor.getString(5));
            recyclerItem.setTotal(cursor.getString(6));
            recyclerItem.setMemo(cursor.getString(7));

            Items.add(recyclerItem);
        }

        return Items;
    }
}
