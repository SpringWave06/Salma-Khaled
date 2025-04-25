package org.example.Entity;
import java.util.Iterator;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    static int id = 0;

    public void AddBook(String name, String description, double price){
        id++;
        Book book = new Book(id, name, description, price);
        books.add(book);
    }

    public void ReturnBook(int id) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void printBooks() {
        books.forEach(System.out::println);
    }
}
