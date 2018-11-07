package com.bychoi00.depositapp;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.UiThread;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private Button btnAdd, btnCalc, btnSendAll;
    private TextView txtResult;
    private MyAdapter myAdapter;
    private List<RecyclerItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        init();
        initListener();
        items = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initListener() {
        btnAdd.setOnClickListener(this);
        btnCalc.setOnClickListener(this);
        btnSendAll.setOnClickListener(this);
    }

    private void init() {
        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnCalc = (Button)findViewById(R.id.buttonCalc);
        btnSendAll = (Button)findViewById(R.id.buttonSendAll);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview1);
        txtResult = (TextView)findViewById(R.id.txtResult);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAdd:
                Intent intent1 = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent1);
                break;
            case R.id.buttonCalc:
                Intent intent2 = new Intent(this,CalcActivity.class);
                startActivity(intent2);
                break;
            case R.id.buttonSendAll:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("전체납부");
                builder.setMessage("전체납부를 하시겠습니까?");
                builder.setPositiveButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //전체납부(구현중)
                    }
                });
                builder.show();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        select();
    }

    void select() {

        try{
            //DB에 추가
            DBHelper helper = new DBHelper(getApplicationContext());
            SQLiteDatabase db = helper.getWritableDatabase();
            Cursor cursor = null;
            cursor = db.rawQuery("select * from tb_deposit", null);
            int count = cursor.getCount();
            items.clear();

            for(int i = 0 ; i < count ; i++){
                cursor.moveToNext();
                String name = cursor.getString(1);
                String rate = cursor.getString(2);
                String decase = cursor.getString(3);
                String date = cursor.getString(4);
                String mMoney = cursor.getString(5);
                String total = cursor.getString(6);
                String memo = cursor.getString(7);

                Log.d("---","------------------------------------------");
                Log.d("TB_DEPOSIT",
                        "name : "+name+"\n"+
                                "rate : "+rate+"\n"+
                                "decase : "+decase+"\n"+
                                "date : "+date+"\n"+
                                "mMoney : "+mMoney+"\n"+
                                "total : "+total+"\n"+
                                "memo : "+memo+"\n");

                items.add(new RecyclerItem(name,rate,date,total));
            }
            myAdapter = new MyAdapter(items);
            recyclerView.setAdapter(myAdapter);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}