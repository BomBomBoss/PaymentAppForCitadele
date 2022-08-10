package com.paymentapp.paymentappforcitadele.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

//Book table creates in resources/schema.sql file when application runs
@Entity
@Table(name = "Book")
@Component
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "year_of_publishing")
    private int year;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name="book_type")
    private String bookType;


    public String getBookType() {
        return bookType;
    }

    public Book() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }



    public Book(String title, String author, int year, String description, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.price = price;

    }
}
