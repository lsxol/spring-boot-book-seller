package com.books.springbootbookseller.repository;

import com.books.springbootbookseller.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
