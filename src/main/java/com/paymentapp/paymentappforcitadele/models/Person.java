package com.paymentapp.paymentappforcitadele.models;

import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public class Person {



    @Pattern(regexp = "^[a-zA-Z]{3,15}$", message = "Please enter your name only with letters between 3 and 15 characters")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{3,15}$", message = "Please enter your surname only with letters between 3 and 20 characters")
    private String surname;

    @NotEmpty(message = "Please enter your email")
    @Email(message = "Please enter valid email")
    private String email;
    private String address;

    private Book book;

    public Person(String name, String surname, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public Person() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
