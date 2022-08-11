package com.paymentapp.paymentappforcitadele.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;

//Person table creates in resources/schema.sql file when application runs
@Entity
@Component
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    //can be used only letters duration from 3 till 15
    @Pattern(regexp = "^[a-zA-Z]{3,15}$", message = "Please enter your name only with letters between 3 and 15 characters ")
    private String name;

    @Column(name = "surname")
    //can be used only letters duration from 3 till 20
    @Pattern(regexp = "^[a-zA-Z]{3,20}$", message = "Please enter your surname only with letters between 3 and 20 characters")
    private String surname;


    @Column(name = "email")
    @NotEmpty(message = "Please enter your email")
    //only email format can be entered
    @Email(message = "Please enter valid email")
    private String email;

    @Column(name = "card_last_four_digits")
    private String cardLastFourDigits;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;


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

    public String getCardLastFourDigits() {
        return cardLastFourDigits;
    }

    public void setCardLastFourDigits(String cardLastFourDigits) {
        this.cardLastFourDigits = cardLastFourDigits;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        return cardLastFourDigits != null ? cardLastFourDigits.equals(person.cardLastFourDigits) : person.cardLastFourDigits == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (cardLastFourDigits != null ? cardLastFourDigits.hashCode() : 0);
        return result;
    }
}
