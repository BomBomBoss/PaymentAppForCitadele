package com.paymentapp.paymentappforcitadele.models;

//This class is created for implementing drop down list (Month) on purchase form for the bank card expiry date.
public class MonthPicker {

    private int month;

    public MonthPicker(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
