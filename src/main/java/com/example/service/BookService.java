package com.example.service;

import com.example.entity.Book;

import java.util.List;

public interface BookService {

    Book createBook(Book book);
    Book getBook(Long id);
    List<Book> getAllBooks();
    Book updateBook(Book id);
    void deleteBook(Long id);
}
