package com.bychoi00.depositapp;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    private EditText AddName, AddRate, AddStartDay, AddEndDay, AddMonthMoney, AddStartMoney, AddMemo;
    private Button AddButton, CancelButton;
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
        setContentView(R.layout.activity_add);
        init();
        AddStartDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                AddStartDay.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        AddEndDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                AddEndDay.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
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
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(AddName.getText().toString()) ||
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

                }
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
        AddName = (EditText) findViewById(R.id.addName);
        AddRate = (EditText) findViewById(R.id.addRate);
        AddStartDay = (EditText) findViewById(R.id.addStartDay);
        AddEndDay = (EditText) findViewById(R.id.addEndDay);
        AddMonthMoney = (EditText) findViewById(R.id.addMonthMoney);
        AddStartMoney = (EditText) findViewById(R.id.addStartMoney);
        AddMemo = (EditText) findViewById(R.id.addMemo);
        AddButton = (Button) findViewById(R.id.addButton);
        CancelButton = (Button) findViewById(R.id.cancelButton);
        RadioGroup1 = (RadioGroup) findViewById(R.id.radioAddGroup);

    }
}
