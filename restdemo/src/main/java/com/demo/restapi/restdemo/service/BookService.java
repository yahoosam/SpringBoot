package com.demo.restapi.restdemo.service;

import com.demo.restapi.restdemo.model.Book;

import java.util.HashSet;

public interface BookService {
    boolean addBook(Book book);

    void deleteAllData();

    Book findBookByID(long id);

    HashSet<Book> getAllBooks();
}
