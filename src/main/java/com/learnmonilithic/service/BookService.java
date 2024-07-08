package com.learnmonilithic.service;

import com.learnmonilithic.entity.Book;
import com.learnmonilithic.payload.request.BookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> getBooks(BookRequest bookRequest);

    Book getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

    List<Book> searchBooksByName(String name);

    List<Book> getBooksByAuthor(Long authorId);

    List<Book> getBooksByCategory(Long categoryId);

    List<Book> getBestSellingBooks();

    List<Book> getLatestBooks();

    List<Book> getOnSaleBooks();
}
