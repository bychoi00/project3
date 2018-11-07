package com.bychoi00.depositapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DialogItemClick extends Dialog implements View.OnClickListener {

    private Button dialogDetail, dialogModify, dialogAdd, dialogCancel;
    private EditText dialogMmoney;


    public DialogItemClick(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_itemclick);
        init();
        initListener();
        //초기값은 DB에서 불러와서 mMoney보여줌. 사용자가 수정할 수 있도록 변경
        //EditText의 값을 DB의 total값과 합하여 다시 DB에 저장.
        String mMoney = dialogMmoney.getText().toString();
    }

    private void init() {
        dialogAdd = (Button) findViewById(R.id.dialog_add);
        dialogCancel = (Button) findViewById(R.id.dialog_cancel);
        dialogDetail = (Button) findViewById(R.id.dialog_detail);
        dialogMmoney = (EditText) findViewById(R.id.dialog_mMoney);
        dialogModify = (Button) findViewById(R.id.dialog_modify);
    }

    private void initListener(){
        dialogAdd.setOnClickListener(this);
        dialogModify.setOnClickListener(this);
        dialogDetail.setOnClickListener(this);
        dialogCancel.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_detail:
                break;
            case R.id.dialog_modify:

                break;
            case R.id.dialog_add:

                break;
            case R.id.dialog_cancel:
                dismiss();
                break;

        }
    }
}
