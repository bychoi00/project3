package com.bychoi00.depositapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalcActivity extends AppCompatActivity {

    private EditText editMonthMoney, editMonths, editRate;
    private TextView normalTotal,normalInterTotal,pre1Total,pre1InterTotal, pre2Total, pre2InterTotal,noTotal,noInterTotal;

    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        //init
        init();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((editMonthMoney.getText().toString() != null) &&
                        (editMonths.getText().toString() != null) &&
                        (editRate.getText().toString() != null)){
                    String monthMoney = editMonthMoney.getText().toString();
                    String months = editMonths.getText().toString();
                    String rate = editRate.getText().toString();

                    int origin;
                    int rawresult;
                    int interNormal;
                    int interPre1;
                    int interPre2;
                    int interNo;

                    DepositCalc depositCalc = new DepositCalc();
                    origin = depositCalc.originCalc(monthMoney,months);
                    rawresult = depositCalc.simpleCalc(monthMoney,months,rate);
                    interNormal = depositCalc.normaltax(rawresult);
                    interPre1 = depositCalc.pre1tax(rawresult);
                    interPre2 = depositCalc.pre2tax(rawresult);
                    interNo = depositCalc.notax(rawresult);

                    normalTotal.setText(getFormatDEC(String.valueOf(origin+interNormal)));
                    normalInterTotal.setText(getFormatDEC(String.valueOf(interNormal)));
                    pre1Total.setText(getFormatDEC(String.valueOf(origin+interPre1)));
                    pre1InterTotal.setText(getFormatDEC(String.valueOf(interPre1)));
                    pre2Total.setText(getFormatDEC(String.valueOf(origin+interPre2)));
                    pre2InterTotal.setText(getFormatDEC(String.valueOf(interPre2)));
                    noTotal.setText(getFormatDEC(String.valueOf(origin+interNo)));
                    noInterTotal.setText(getFormatDEC(String.valueOf(interNo)));
                }
                else{
                    Toast.makeText(getApplicationContext(),"모든 항목을 기재해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static String getFormatDEC(String number) {
        DecimalFormat dec = new DecimalFormat("##,###,###");
        if (!number.trim().equals("")) {
            number = dec.format(Long.valueOf(number));
        }
        return number;
    }

    private void init() {
        editMonthMoney = (EditText)findViewById(R.id.editMonthMoney);
        editMonths = (EditText)findViewById(R.id.editMonths);
        editRate = (EditText)findViewById(R.id.editRate);
        normalTotal = (TextView)findViewById(R.id.normaltaxTotal);
        normalInterTotal = (TextView)findViewById(R.id.normaltaxInterTotal);
        pre1Total = (TextView)findViewById(R.id.pre1taxTotal);
        pre1InterTotal = (TextView)findViewById(R.id.pre1taxInterTotal);
        pre2Total = (TextView)findViewById(R.id.pre2taxTotal);
        pre2InterTotal = (TextView)findViewById(R.id.pre2InterTotal);
        noTotal = (TextView)findViewById(R.id.notaxTotal);
        noInterTotal = (TextView)findViewById(R.id.noInterTotal);
        btnResult = (Button)findViewById(R.id.btnResult);
    }
}
