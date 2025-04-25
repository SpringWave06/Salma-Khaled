package org.example;

import org.example.Entity.Book;
import org.example.Entity.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.AddBook("Salma", "Salma's Book", 250);
        library.AddBook("Habiba", "Habiba's Book", 150);
        library.printBooks();
        library.ReturnBook(2);
        library.printBooks();
    }
}