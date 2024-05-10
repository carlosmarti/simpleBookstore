package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PostMapping("{name}")
    public ResponseEntity<String> sayHello(@PathVariable("name") String name){
        String message = "Hello there " + name;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId){
        Book book = bookService.getBook(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book){
        book.setId(id);
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book was Deleted!", HttpStatus.OK);
    }

}
