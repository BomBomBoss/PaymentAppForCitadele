package com.paymentapp.paymentappforcitadele.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Component
@Entity
@Table(name = "Bankcard")
public class BankCard {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;



    @Pattern(regexp = "^\\d{12,19}", message = "Card Number Length should be from 12 till 19 numbers")
    @Column(name = "card_number")
    private String cardNumber;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiry_date")
    private LocalDate expiryDate;



    @Pattern(regexp = "^\\d{3,4}", message = "Please enter correct verification number. 3-4 numbers allowed")
    @Column(name = "verification_code")
    private String verificationCode;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDate=" + expiryDate +
                ", verificationCode='" + verificationCode + '\'' +
                ", person=" + person +
                '}';
    }


}
