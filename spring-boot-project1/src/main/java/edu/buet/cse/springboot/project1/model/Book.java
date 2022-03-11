package edu.buet.cse.springboot.project1.model;

import java.util.Objects;

/**
 * A simple model class to represent a book
 * 
 * @author shamim
 */
public class Book {
  private final Long id;
  private final String title;
  private final String author;

  public Book(Long id, String title, String author) {
    this.id = Objects.requireNonNull(id);
    this.title = Objects.requireNonNull(title);
    this.author = Objects.requireNonNull(author);
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public String toString() {
    return String.format("[ id: %d, title: %s, author: %s ]", id, title, author);
  }
}
