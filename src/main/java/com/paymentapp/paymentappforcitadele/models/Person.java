package com.paymentapp.paymentappforcitadele.models;

import org.aspectj.bridge.IMessage;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Component
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @Pattern(regexp = "^[a-zA-Z]{3,15}$", message = "Please enter your name only with letters between 3 and 15 characters")
    private String name;

    @Column(name = "surname")
    @Pattern(regexp = "^[a-zA-Z]{3,15}$", message = "Please enter your surname only with letters between 3 and 20 characters")
    private String surname;


    @Column(name = "email")
    @NotEmpty(message = "Please enter your email")
    @Email(message = "Please enter valid email")
    private String email;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @OneToOne(mappedBy = "person", cascade = CascadeType.MERGE)
    private BankCard bankCard;

    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", book=" + book +
                '}';
    }
}
