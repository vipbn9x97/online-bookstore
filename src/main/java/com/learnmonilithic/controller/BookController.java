package com.learnmonilithic.controller;

import com.learnmonilithic.entity.Book;
import com.learnmonilithic.payload.request.BookRequest;
import com.learnmonilithic.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@ModelAttribute BookRequest request,
                                                  @RequestParam(defaultValue = "0") int pageNumber,
                                                  @RequestParam(defaultValue = "10") int pageSize) {
        List<Book> bookList = bookService.getBooks(request);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.createBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("{bookId}")
    public ResponseEntity<Book> getBookByID(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }
    @PutMapping("{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") Long bookId, @RequestBody Book book) {
        //user.setId(userId);
        Book updatedBook = bookService.updateBook(bookId, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Delete book successfully", HttpStatus.OK);
    }
}
