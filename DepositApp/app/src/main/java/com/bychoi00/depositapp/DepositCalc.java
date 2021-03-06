package com.bychoi00.depositapp;

import java.nio.DoubleBuffer;

public class DepositCalc {

    private double ratenormal = (double)0.154;
    private double ratepre1 = (double)0.095;
    private double ratepre2 = (double)0.014;

    public int totalSum(String origin, String interest){
        int origin1 = Integer.parseInt(origin);
        int interest1 = Integer.parseInt(interest);
        int result = origin1+interest1;

        return result;
    }

    public int originCalc(String monthMoney, String months){
        int result = Integer.parseInt(monthMoney)*Integer.parseInt(months);
        return result;
    }

    public int simpleCalc(String monthMoney, String months,String rate){
        double mMoney = Double.parseDouble(monthMoney);
        double mths = Double.parseDouble(months);
        double rat = Double.parseDouble(rate);

        double result1 = (mMoney*mths*(mths+1)*rat)/(2*12*100);
        long result2 = Math.round(result1);
        return (int)result2;
    }
    public int compoundCalc(String monthMoney, String months, String rate){
        double mMoney = Double.parseDouble(monthMoney);
        double mths = Double.parseDouble(months);
        double rat = Double.parseDouble(rate);
        double rat2 = rat/100;

        double a = Math.pow((1+rat2),(1.0/12.0));
        double result1 = mMoney*(a*(Math.pow(a,mths)-1))/(a-1);
        double result2 = result1 - (mMoney*mths);
        long result3 = Math.round(result2);

        return (int)result3;
    }
    public int normaltax(int rawresult){
        double temp = (double)(rawresult*(1-ratenormal));
        long result1 = Math.round(temp);
        int result = (int)result1;
        return result;
    }
    public int pre1tax(int rawresult){
        double temp = (double) (rawresult*(1-ratepre1));
        long result1 = Math.round(temp);
        int result = (int)result1;
        return result;

    }
    public int pre2tax(int rawresult){
        double temp = (double) (rawresult*(1-ratepre2));
        long result1 = Math.round(temp);
        int result = (int)result1;
        return result;

    }
    public int notax(int rawresult){
        return rawresult;
    }
}