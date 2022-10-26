import org.example.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LibraryTests {
    static Book book1 = new Book("Chemistry",5);
    static Book book2 = new Book("Physics", 1);
    static Book book3 = new Book("Maths", 2);
    static Book book4 = new Book("Biology", 5);
    static Book book5 = new Book("Technical Drawing", 0);
    static List<Book> books = new ArrayList<>();
    static Teacher teacher1 = new Teacher("Mr Dan",book1);

    static Teacher teacher2 = new Teacher("Mrs Petty",book2);

    static SeniorStudent senior1 = new SeniorStudent("Adams Raiola",book2);
    static SeniorStudent senior2 = new SeniorStudent("Michelle Bama",book2);
    static SeniorStudent senior3 = new SeniorStudent("Danny Phantom",book3);

    static JuniorStudent junior1 = new JuniorStudent("Kate Harrington",book1);
    static JuniorStudent junior2 = new JuniorStudent("Jimmy Hendricks",book5);
    static JuniorStudent junior3 = new JuniorStudent("Mike Bilzerian",book1);

    static Librarian librarian = new Librarian("Harry");

    @BeforeAll
    public static void initializer(){
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }
    @Test
    public void borrowBook(){
        librarian.borrowBook(book3,teacher1);
        librarian.borrowBook(book3,senior1);
        librarian.borrowBook(book3,junior1);

    }
    @Test
    public void borrowBookFCFS(){
        Queue<Members> wantBooks = new LinkedList<>();
        wantBooks.add(junior1);
        wantBooks.add(senior1);
        wantBooks.add(teacher1);
        librarian.borrowBookFCFS(wantBooks);
    }

    @Test
    public void borrowBookPriority(){
        List<Members> wantBooks = new ArrayList<Members>();
        wantBooks.add(junior1);
        wantBooks.add(senior1);
        wantBooks.add(teacher1);
        librarian.borrowBookPriority(book1, wantBooks);
    }
}
