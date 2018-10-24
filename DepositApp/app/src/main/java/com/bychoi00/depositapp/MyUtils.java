package com.bychoi00.depositapp;

import java.text.DecimalFormat;

public class MyUtils {
    public static String getFormatDEC(String number) {
        DecimalFormat dec = new DecimalFormat("##,###,###");
        if (!number.trim().equals("")) {
            number = dec.format(Long.valueOf(number));
        }
        return number;
    }
}
