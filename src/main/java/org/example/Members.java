package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Members {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected Integer id;
    protected String name;
    public List<Book> listOfBooksInPossession;

    public Members(String name){
        this.name= name;
        this.id=count.incrementAndGet();
        this.listOfBooksInPossession=new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void returnBook(){

    }


}
