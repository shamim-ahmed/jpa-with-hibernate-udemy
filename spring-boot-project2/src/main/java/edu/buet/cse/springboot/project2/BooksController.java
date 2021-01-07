package edu.buet.cse.springboot.project2;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
  private Book[] bookArray = {new Book(11L, "Beginning Java 7", "Ivor Horton"),
      new Book(21L, "Spring in Action", "Craig Walls"),
      new Book(31L, "Effective Java", "Joshua Bloch")};

  @GetMapping("/books")
  public List<Book> getBooks() {
    return Arrays.asList(bookArray);
  }
}
