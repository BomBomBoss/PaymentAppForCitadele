package com.paymentapp.paymentappforcitadele.models;

public class Book {

    private static int counter = 1;
    private int id;
    private String title;
    private String author;
    private int year;
    private String description;
    private double price;

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
        this.id = counter;
        counter++;

    }
}
