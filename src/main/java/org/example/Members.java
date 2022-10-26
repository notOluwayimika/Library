package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Members {
    protected int priority;
    private static final AtomicInteger count = new AtomicInteger(0);
    protected Integer id;
    protected String name;
    public List<Book> listOfBooksInPossession;
    public Book bookToBorrow;

    public Members(String name,Book bookToBorrow){
        this.name= name;
        this.id=count.incrementAndGet();
        this.listOfBooksInPossession=new ArrayList<>();
        this.bookToBorrow=bookToBorrow;
        this.priority=0;
    }

    public String getName() {
        return name;
    }

    public Book getBookToBorrow() {
        return bookToBorrow;
    }

    public int getPriority() {
        return priority;
    }
}
