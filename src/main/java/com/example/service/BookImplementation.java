package com.example.service;

import com.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImplementation implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> opBook = bookRepository.findById(id);
        return opBook.get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId()).get();
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setDescription(book.getDescription());
        Book updatedBook = bookRepository.save(existingBook);

        return updatedBook;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
