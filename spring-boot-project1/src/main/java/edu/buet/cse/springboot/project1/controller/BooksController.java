package edu.buet.cse.springboot.project1.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.buet.cse.springboot.project1.model.Book;

@RestController
public class BooksController {
  @GetMapping("/books")
  public List<Book> getBooks() {
    return Arrays.asList(new Book(1L, "Beginning Java", "Ivor Horton"),
        new Book(2L, "Java How to Program", "Paul Deitel"));
  }
}
