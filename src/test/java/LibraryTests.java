import org.example.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryTests {
    static List<Book> books = new ArrayList<>();
    static Teacher teacher1 = new Teacher("Mr Dan");

    static Teacher teacher2 = new Teacher("Mrs Petty");

    static SeniorStudent senior1 = new SeniorStudent("Adams Raiola");
    static SeniorStudent senior2 = new SeniorStudent("Michelle Bama");
    static SeniorStudent senior3 = new SeniorStudent("Danny Phantom");

    static JuniorStudent junior1 = new JuniorStudent("Kate Harrington");
    static JuniorStudent junior2 = new JuniorStudent("Jimmy Hendricks");
    static JuniorStudent junior3 = new JuniorStudent("Mike Bilzerian");
    static Book book1 = new Book("Chemistry",5);
    static Book book2 = new Book("Physics", 1);
    static Book book3 = new Book("Maths", 2);
    static Book book4 = new Book("Biology", 5);
    static Book book5 = new Book("Technical Drawing", 0);
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
        List<Members> wantBooks = new ArrayList<Members>();
        wantBooks.add(junior1);
        wantBooks.add(senior1);
        wantBooks.add(teacher1);
        librarian.borrowBookFCFS(book3,wantBooks);
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
