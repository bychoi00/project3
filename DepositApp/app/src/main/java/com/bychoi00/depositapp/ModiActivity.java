package com.bychoi00.depositapp;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class ModiActivity extends AppCompatActivity {

    private EditText ModiName, ModiRate, ModiStartDay, ModiEndDay, ModiMonthMoney, ModiStartMoney, ModiMemo;
    private Button ModiButton, CancelButton;
    private RadioGroup RadioGroup1;
    private String depositCase = "Simple";

    // Get Current Date
    private Calendar c = Calendar.getInstance();
    private int mYear = c.get(Calendar.YEAR);
    private int mMonth = c.get(Calendar.MONTH);
    private int mDay = c.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modi);

        init();

        //불러온 ListView의 position에 맞는 item 불러들이기

        ModiStartDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ModiActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                ModiStartDay.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        ModiEndDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ModiActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                ModiEndDay.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        RadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioAdd1:
                        //단리
                        depositCase = "Simple";
                        break;

                    case R.id.radioAdd2:
                        //복리
                        depositCase = "Compound";
                        break;
                }
            }
        });

        ModiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (TextUtils.isEmpty(AddName.getText().toString()) ||
                        (TextUtils.isEmpty(AddRate.getText().toString())) ||
                        (TextUtils.isEmpty(AddStartDay.getText().toString())) ||
                        (TextUtils.isEmpty(AddEndDay.getText().toString())) ||
                        (TextUtils.isEmpty(AddMonthMoney.getText().toString())) ||
                        (TextUtils.isEmpty(AddStartMoney.getText().toString()))
                        ) {

                    Toast.makeText(getApplicationContext(), "모든 항목을 기재해주세요.", Toast.LENGTH_SHORT).show();

                } else {
                    try{
                        //DB에 추가
                        DBHelper helper = new DBHelper(getApplicationContext());
                        SQLiteDatabase db = helper.getWritableDatabase();
                        ContentValues cv= new ContentValues();
                        cv.put("name",AddName.getText().toString());
                        cv.put("rate",AddRate.getText().toString());
                        cv.put("decase",depositCase);
                        cv.put("date",AddStartDay.getText().toString()+" ~ "+AddEndDay.getText().toString());
                        cv.put("mMoney",AddMonthMoney.getText().toString());
                        cv.put("total",AddStartMoney.getText().toString());
                        cv.put("memo",AddMemo.getText().toString());
                        db.insert("tb_deposit",null,cv);
                        Toast.makeText(getApplicationContext(), "항목이 추가되었습니다.", Toast.LENGTH_SHORT).show();
                        db.close();
                        finish();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }*/
            }
        });
        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void init() {
        ModiName = (EditText) findViewById(R.id.modi_Name);
        ModiRate = (EditText) findViewById(R.id.modi_Rate);
        ModiStartDay = (EditText) findViewById(R.id.modi_StartDay);
        ModiEndDay = (EditText) findViewById(R.id.modi_EndDay);
        ModiMonthMoney = (EditText) findViewById(R.id.modi_MonthMoney);
        ModiStartMoney = (EditText) findViewById(R.id.modi_StartMoney);
        ModiMemo = (EditText) findViewById(R.id.modi_Memo);
        ModiButton = (Button) findViewById(R.id.modi_Button);
        CancelButton = (Button) findViewById(R.id.modi_cancelButton);
        RadioGroup1 = (RadioGroup) findViewById(R.id.modi_radioGroup);

    }
}
