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



    @NotNull(message = "Please enter card number")
    @Pattern(regexp = "^\\d{16}", message = "Please enter correct verification number. 16 numbers allowed")
    @Column(name = "card_number")
    private String cardNumber;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "bankcard_year")
    private int year;

    @Column(name = "bankcard_month")
    private int month;


    @NotNull(message = "Please enter card verification number")
    @Pattern(regexp = "^\\d{3}", message = "Please enter correct verification number. 3 numbers allowed")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankCard bankCard = (BankCard) o;

        if (year != bankCard.year) return false;
        if (month != bankCard.month) return false;
        if (cardNumber != null ? !cardNumber.equals(bankCard.cardNumber) : bankCard.cardNumber != null) return false;
        if (expiryDate != null ? !expiryDate.equals(bankCard.expiryDate) : bankCard.expiryDate != null) return false;
        return verificationCode != null ? verificationCode.equals(bankCard.verificationCode) : bankCard.verificationCode == null;
    }

    @Override
    public int hashCode() {
        int result = cardNumber != null ? cardNumber.hashCode() : 0;
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + month;
        result = 31 * result + (verificationCode != null ? verificationCode.hashCode() : 0);
        return result;
    }
}
