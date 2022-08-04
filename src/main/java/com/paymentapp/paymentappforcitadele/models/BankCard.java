package com.paymentapp.paymentappforcitadele.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Component
public class BankCard {

    @NotNull(message = "Please enter card number")
    @Pattern(regexp = "^\\d{16}", message = "Please enter correct verification number")
    private String cardNumber;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

    private int year;

    private int month;


    @NotNull(message = "Please enter card verification number")
    @Pattern(regexp = "^\\d{3}", message = "Please enter correct verification number")
    private String verificationCode;

    @Valid
    private Person person;

    public BankCard() {
    }

    @Autowired
    public BankCard(Person person) {
        this.person = person;
    }

    public BankCard(String cardNumber, LocalDate expiryDate, String verificationCode, Person person) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.verificationCode = verificationCode;
        this.person = person;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }



    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
