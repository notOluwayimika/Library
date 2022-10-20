package org.example;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    private String name;
    public Librarian(String name) {
        this.name = name;
    }
    public void borrowBook(Book book1, Members member) {
        if(book1.getNumberOfBooksInStorage()>0){
            if(member instanceof Teacher){
                System.out.println("Borrowing book: "+book1.getName()+ " to a teacher "+member.getName());
            } else if(member instanceof SeniorStudent){
                System.out.println("Borrowing book: "+book1.getName()+ " to a senior "+member.getName());
            }else if(member instanceof JuniorStudent){
                System.out.println("Borrowing book: "+book1.getName()+ " to a junior "+member.getName());
            }
            member.listOfBooksInPossession.add(book1);
            book1.setNumberOfBooksInStorage(book1.getNumberOfBooksInStorage()-1);
        } else {
            System.out.println("This book is currently unavailable, book taken");
        }


    }

    public void borrowBookFCFS(Book book, List<Members> wantBooks) {
        for(int i=0; i<wantBooks.size();i++){
            if(book.getNumberOfBooksInStorage()>0){
                if(wantBooks.get(i) instanceof Teacher){
                    System.out.println("Borrowing book: "+book.getName()+ " to a teacher "+wantBooks.get(i).getName());
                } else if( wantBooks.get(i) instanceof SeniorStudent){
                    System.out.println("Borrowing book: "+book.getName()+ " to a senior "+wantBooks.get(i).getName());
                } else if (wantBooks.get(i) instanceof  JuniorStudent){
                    System.out.println("Borrowing book: "+book.getName()+ " to a junior "+wantBooks.get(i).getName());
                }
                wantBooks.get(i).listOfBooksInPossession.add(book);
                book.setNumberOfBooksInStorage(book.getNumberOfBooksInStorage()-1);
            }else{
                System.out.println("This book is currently unavailbale, book taken");
            }
        }
    }

    public void borrowBookPriority(Book book, List<Members> wantBooks) {
        List<Members> priorityList = new ArrayList<>();
        for(int i=0;i<wantBooks.size();i++){
            if(wantBooks.get(i) instanceof Teacher){
                priorityList.add(wantBooks.get(i));
            }
        }
        for(int i=0;i<wantBooks.size();i++){
            if(wantBooks.get(i) instanceof SeniorStudent){
                priorityList.add(wantBooks.get(i));
            }
        }
        for(int i=0;i<wantBooks.size();i++){
            if(wantBooks.get(i) instanceof JuniorStudent){
                priorityList.add(wantBooks.get(i));
            }
        }
        for(int i=0; i<priorityList.size();i++){
            if(book.getNumberOfBooksInStorage()>0){
                if(priorityList.get(i) instanceof Teacher){
                    System.out.println("Borrowing book: "+book.getName()+ " to a teacher "+priorityList.get(i).getName());
                } else if( priorityList.get(i) instanceof SeniorStudent){
                    System.out.println("Borrowing book: "+book.getName()+ " to a senior "+priorityList.get(i).getName());
                } else if (priorityList.get(i) instanceof  JuniorStudent){
                    System.out.println("Borrowing book: "+book.getName()+ " to a junior "+priorityList.get(i).getName());
                }
                priorityList.get(i).listOfBooksInPossession.add(book);
                book.setNumberOfBooksInStorage(book.getNumberOfBooksInStorage()-1);
            }else{
                System.out.println("This book is currently unavailbale, book taken");
            }
        }

    }
}
