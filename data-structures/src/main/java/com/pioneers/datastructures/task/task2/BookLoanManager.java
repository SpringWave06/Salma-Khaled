package com.pioneers.datastructures.task.task2;

import java.util.*;

public class BookLoanManager {
    private final List<Book> books;

    public BookLoanManager() {
        books = new LinkedList<>(Arrays.asList(
                new Book(1, "book1"),
                new Book(2, "book2"),
                new Book(3, "book3"),
                new Book(4, "book4")
        ));
    }

    // TODO: Improve the performance to be O(1) instead of on O(n)
    //  You have the choice to change the structure of the code inside this package.
    public Optional<Book> getBookByTitle(String title) {
        return books.stream()
                .filter(book -> isBookTitleMatched(title, book))
                .findFirst();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    private boolean isBookTitleMatched(String name, Book book) {
        return book.getTitle().equalsIgnoreCase(name);
    }
}
