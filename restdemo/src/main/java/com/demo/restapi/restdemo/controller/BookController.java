package com.demo.restapi.restdemo.controller;

import com.demo.restapi.restdemo.model.Book;
import com.demo.restapi.restdemo.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
public class BookController {

    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/")
    public String addBook(@RequestBody Book book) {
        if (bookServiceImpl.addBook(book))
            return "Added: " + book;
        else
            return "Book already present..." + book;
    }

    @DeleteMapping("/removeall")
    public String deleteAllData() {
        bookServiceImpl.deleteAllData();
        return "Cleared the list...";
    }

    @GetMapping("/findbyid/{id}")
    public String findBookByID(@PathVariable long id) {
        Book book = bookServiceImpl.findBookByID(id);
        if (book != null)
            return "Found: " + book;
        else
            return "Not found...";
    }

    @GetMapping("/getallbooks")
    public HashSet<Book> getAllBooks() {
        return bookServiceImpl.getAllBooks();
    }
}
