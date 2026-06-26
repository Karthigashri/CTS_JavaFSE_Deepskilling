package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;   // NEW

    public void setBookRepository(BookRepository bookRepository) {   // NEW
        this.bookRepository = bookRepository;
    }

    public void displayService() {
        System.out.println("Book Service Object Created");

        bookRepository.displayRepository();
    }
}