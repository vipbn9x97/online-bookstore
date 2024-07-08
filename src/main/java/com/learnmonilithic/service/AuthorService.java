package com.learnmonilithic.service;

import com.learnmonilithic.entity.Author;
import com.learnmonilithic.entity.Book;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();

    Author getAuthorById(Long id);

    Author createAuthor(Author author);

    Author updateAuthor(Long id, Author author);

    void deleteAuthor(Long id);

    List<Author> searchAuthorsByName(String name);

    List<Book> getBooksByAuthor(Long authorId);

    List<Author> getAuthorsByCategory(Long categoryId);
}
