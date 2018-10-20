package com.bychoi00.depositapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcActivity extends AppCompatActivity {
    private EditText editMonthMoney;
    private EditText editMonths;
    private EditText editRate;
    private Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        editMonthMoney = (EditText)findViewById(R.id.editMonthMoney);
        editMonths = (EditText)findViewById(R.id.editMonths);
        editRate = (EditText)findViewById(R.id.editRate);
        btnResult = (Button)findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DepositCalc depositCalc = new DepositCalc();
                int rawresult;
                int result1;
                int result2;
                int result3;
                int result4;

                rawresult = depositCalc.simpleCalc(editMonthMoney.getText().toString(),editMonths.getText().toString(),editRate.getText().toString());
                result1 = depositCalc.normaltax(rawresult);
                result2 = depositCalc.pre1tax(rawresult);
                result3 = depositCalc.pre2tax(rawresult);
                result4 = depositCalc.notax(rawresult);
            }
        });
    }
}
