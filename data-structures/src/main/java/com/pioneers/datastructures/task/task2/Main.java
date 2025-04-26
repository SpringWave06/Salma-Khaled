package com.pioneers.datastructures.task.task2;

public class Main {
    public static void main(String[] args) {

        Book cleanCodeBook = new Book(5, "Clean Code");
        Book mazidiBook = new Book(6, "Makzidi");

        // TODO: try to think how to increase the performance here.

        BookLoanManager bookLoanManager = new BookLoanManager();
        bookLoanManager.addBook(cleanCodeBook);
        bookLoanManager.addBook(mazidiBook);

        bookLoanManager.removeBook(mazidiBook);

        bookLoanManager.getBookByTitle("Clean Code")
                .ifPresent(System.out::println);
    }
}
