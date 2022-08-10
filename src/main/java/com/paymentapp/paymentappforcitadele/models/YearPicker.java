package com.paymentapp.paymentappforcitadele.models;


//This class is created for implementing drop down list (Year) on purchase form for the bank card expiry date.
public class YearPicker {

    private int shortYear;

    public YearPicker(int shortYear) {
        this.shortYear = shortYear;
    }

    public int getShortYear() {
        return shortYear;
    }

    public void setShortYear(int shortYear) {
        this.shortYear = shortYear;
    }
}
