package org.example;

public class JuniorStudent extends Members{
    private int priority = 3;
    public JuniorStudent(String name,Book bookToBorrow) {
        super(name,bookToBorrow);
        super.priority=3;

    }
}


