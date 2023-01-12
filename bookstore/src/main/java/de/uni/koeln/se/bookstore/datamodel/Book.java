package de.uni.koeln.se.bookstore.datamodel;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String author;
    private Integer yearDate;

    public Book(){}

    public Book(String name, String author, Integer year){
        this.name = name;
        this.author = author;
        this.yearDate = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearDate() {
        return yearDate;
    }

    public void setYearDate(Integer year) {
        this.yearDate = year;
    }
}
