package org.example;

public class SeniorStudent extends Members {


    public SeniorStudent(String name, Book bookToBorrow) {
        super(name,bookToBorrow);
        super.priority=2;

    }

}
