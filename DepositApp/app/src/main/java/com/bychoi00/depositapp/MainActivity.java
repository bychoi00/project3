package com.bychoi00.depositapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<RecyclerItem> items;
    private RecyclerView recyclerView;
    private Button btnAdd, btnCalc, btnSendAll;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        init();
        initListener();

        items = new ArrayList<>();
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));
        items.add(new RecyclerItem("적금1","1.1","212121","1111111"));

        //init
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(items);
        recyclerView.setAdapter(myAdapter);

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
                select();
                Toast.makeText(this,"all 클릭",Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        select();
    }

    void select() {
        //DB에 추가
        DBHelper helper = new DBHelper(getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = null ;
        cursor = db.rawQuery("select * from tb_deposit", null);
        while(cursor.moveToNext()) {
            String name = cursor.getString(0);
            String rate = cursor.getString(1);
            String decase = cursor.getString(2);
            String date = cursor.getString(3);
            String mMoney = cursor.getString(4);
            String total = cursor.getString(5);
            String memo = cursor.getString(6);
            Log.d("---","------------------------------------------");
            Log.d("TB_DEPOSIT",
                            "name : "+name+"\n"+
                            "rate : "+rate+"\n"+
                            "decase : "+decase+"\n"+
                            "date : "+date+"\n"+
                            "mMoney : "+mMoney+"\n"+
                            "total : "+total+"\n"+
                            "memo : "+memo+"\n");
            Toast.makeText(this, "TTTTTTTTTTTTTTTTTTTTTTT", Toast.LENGTH_SHORT).show();
        }
    }
   /* public void selectButtonClick(View v){   // 항상 DB문을 쓸때는 예외처리(try-catch)를 해야한다

        try {
            sql = "select * from "+ "tb_deposit";

            resultset = db.rawQuery(sql, null);   // select 사용시 사용(sql문, where조건 줬을 때 넣는 값)

            int count = resultset.getCount();   // db에 저장된 행 개수를 읽어온다
            result = new String[count];   // 저장된 행 개수만큼의 배열을 생성

            for (int i = 0; i < count; i++) {
                resultset.moveToNext();   // 첫번째에서 다음 레코드가 없을때까지 읽음
                String str_name = resultset.getString(0);   // 첫번째 속성
                String str_phone = resultset.getString(1);   // 두번째 속성
                String str_email = resultset.getString(2);   // 세번째 속성
                result[i] = str_name + " " + str_phone + " " + str_email;   // 각각의 속성값들을 해당 배열의 i번째에 저장
            }

            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, result);   // ArrayAdapter(this, 출력모양, 배열)
            listView.setAdapter(adapter);   // listView 객체에 Adapter를 붙인다

        } catch (Exception e) {
            System.out.println("select Error :  " + e);
        }

    }*/
}