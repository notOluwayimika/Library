package org.example;

public class Teacher extends Members{
    public Teacher(String name,Book bookToBorrow) {
        super(name,bookToBorrow);
        super.priority=1;
    }
}

