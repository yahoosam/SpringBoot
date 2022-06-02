package com.demo.restapi.restdemo.service;

import com.demo.restapi.restdemo.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class BookServiceImpl implements BookService {

    HashSet<Book> bookList = new HashSet<Book>();

    @Override
    public boolean addBook(Book book) {
        if (bookList.add(book))
            return true;
        else
            return false;
    }

    @Override
    public void deleteAllData() {
        bookList.clear();
    }

    @Override
    public Book findBookByID(long id) {
        return bookList.stream().filter(b -> b.getId() == id).findAny().orElse(null);
    }

    @Override
    public HashSet<Book> getAllBooks() {
        return bookList;
    }
}
