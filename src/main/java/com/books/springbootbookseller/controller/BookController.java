package com.books.springbootbookseller.controller;

import com.books.springbootbookseller.model.Book;
import com.books.springbootbookseller.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book")
public class BookController {

  @Autowired
  private IBookService bookService;
  @PostMapping()
  public ResponseEntity<?> saveBook(@RequestBody Book book) {
    return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @GetMapping
  public ResponseEntity<?> getAllBooks() {
    return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
  }
}
