package com.bychoi00.depositapp;

public class DepositCalc {

    private float ratenormal = (float)0.154;
    private float ratepre1 = (float)0.095;
    private float ratepre2 = (float)0.014;

    public int simpleCalc(String monthMoney, String months,String rate){
        int mMoney = Integer.parseInt(monthMoney);
        int mths = Integer.parseInt(months);
        float rat = Float.parseFloat(rate);

        float result = (mMoney*mths*(mths+1)*rat)/(2*12*100);
        return (int)result;
    }
    public int compoundCalc(){
        return 1;
    }
    public int normaltax(int rawresult){
        int result = (int)(rawresult*(1-ratenormal));
        return result;
    }
    public int pre1tax(int rawresult){
        int result = (int)(rawresult*(1-ratepre1));
        return result;

    }
    public int pre2tax(int rawresult){
        int result = (int)(rawresult*(1-ratepre2));
        return result;

    }
    public int notax(int rawresult){
        return rawresult;
    }
}