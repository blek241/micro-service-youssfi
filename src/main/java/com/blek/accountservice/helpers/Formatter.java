package com.blek.accountservice.helpers;

import java.text.DecimalFormat;

public class Formatter {

    static DecimalFormat decimalFormat= new DecimalFormat("#.##");

    public static Double formatNumber(double value){
        return Double.valueOf(decimalFormat.format(value));
    }

}
