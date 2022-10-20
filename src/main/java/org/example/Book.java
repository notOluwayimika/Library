package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private String name;
    private static final AtomicInteger countBook = new AtomicInteger(0);
    private Integer numberOfBooksInStorage;
    private Integer id;

    public Book(String name, Integer numberOfBooksInStorage) {
        this.name = name;
        this.numberOfBooksInStorage = numberOfBooksInStorage;
        this.id = countBook.incrementAndGet();
    }

    public Integer getNumberOfBooksInStorage() {
        return numberOfBooksInStorage;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfBooksInStorage(Integer numberOfBooksInStorage) {
        this.numberOfBooksInStorage = numberOfBooksInStorage;
    }
}
