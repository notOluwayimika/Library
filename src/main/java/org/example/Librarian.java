package org.example;

import java.util.*;

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

    public void borrowBookFCFS(Queue<Members> wantBooks) {
        int counter = wantBooks.size();
        for(int i=0; i<counter;i++){
            Members order = wantBooks.poll();
            Book bookToBorrow = order.getBookToBorrow();
            if (order.getBookToBorrow().getNumberOfBooksInStorage()>0){
                System.out.println("Borrowing book "+bookToBorrow.getName()+" to " + order.getName());
                order.listOfBooksInPossession.add(bookToBorrow);
                bookToBorrow.setNumberOfBooksInStorage(bookToBorrow.getNumberOfBooksInStorage()-1);
            } else {
                System.out.println("Book unavailable");
            }
        }
    }


    public void borrowBookPriority(Book book, List<Members> wantBooks) {
        Queue<Members> priorityList = new PriorityQueue<>(new customComparator());
        int counter = wantBooks.size();
        for(int i = 0; i<counter;i++){
            priorityList.add(wantBooks.get(i));
        }
        for(int i = 0; i<counter;i++){
            Members order = priorityList.poll();
            Book bookToBorrow = order.getBookToBorrow();
            if(order.getBookToBorrow().getNumberOfBooksInStorage()>0){
                System.out.println("Borrowing book "+bookToBorrow.getName()+" to " + order.getName());
                order.listOfBooksInPossession.add(bookToBorrow);
                bookToBorrow.setNumberOfBooksInStorage(bookToBorrow.getNumberOfBooksInStorage()-1);
            } else {
                System.out.println("Book unavailbale");
            }
        }
    }
    static class customComparator implements Comparator<Members>{
        @Override
        public int compare(Members o1, Members o2){
            if (o1.getBookToBorrow()==o2.getBookToBorrow()){
                return o1.getPriority()> o2.getPriority()?1:-1;
            }
            return 1;
        }
    }

}
