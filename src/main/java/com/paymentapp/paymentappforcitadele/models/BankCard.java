package com.paymentapp.paymentappforcitadele.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Component
public class BankCard {

    @Pattern(regexp = "^\\d{12,19}", message = "Card number length should be from 12 till 19 numbers")
    private String cardNumber;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;



    @Pattern(regexp = "^\\d{3,4}", message = "Please enter correct verification number: 3-4 numbers allowed")
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



    @Override
    public String toString() {
        return "BankCard{" +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDate=" + expiryDate +
                ", verificationCode='" + verificationCode + '\'' +
                ", person=" + person +
                '}';
    }


}
