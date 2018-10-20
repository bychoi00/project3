package com.bychoi00.depositapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<String> list;
    private RecyclerView recyclerView;
    private Button btnAdd, btnCalc, btnSendAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        init();
        initListener();

        list = new ArrayList<>();
        list.add("적금1");
        list.add("적금2");
        list.add("적금3");
        list.add("적금4");
        list.add("적금5");
        list.add("적금6");


        //init
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(list));
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
                Toast.makeText(this,"add 클릭",Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonCalc:
                Intent intent = new Intent(this,CalcActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonSendAll:
                Toast.makeText(this,"all 클릭",Toast.LENGTH_SHORT).show();

                break;
        }
    }
}