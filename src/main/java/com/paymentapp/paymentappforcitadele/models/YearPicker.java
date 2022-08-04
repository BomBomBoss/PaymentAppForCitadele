package com.paymentapp.paymentappforcitadele.models;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;

import java.time.LocalDate;

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
