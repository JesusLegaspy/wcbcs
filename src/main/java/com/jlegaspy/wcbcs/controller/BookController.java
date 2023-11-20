package com.jlegaspy.wcbcs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlegaspy.wcbcs.exception.BookNotFoundException;
import com.jlegaspy.wcbcs.model.Book;
import com.jlegaspy.wcbcs.repository.BookRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class BookController {

  private final BookRepository repository;

  BookController(BookRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/books")
  List<Book> all() {
    return repository.findAll();
  }

  @PostMapping("/books")
  Book newBook(@RequestBody Book newBook) {
    return repository.save(newBook);
  }

  @GetMapping("/books/{id}")
  Book one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
  }

  @PutMapping("/books/{id}")
  Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
    return repository.findById(id).map(book -> {
      book.setTitle(newBook.getTitle());
      book.setArkId(newBook.getArkId());
      book.setSeries(newBook.getSeries());
      book.setImage(newBook.getImage());
      book.setChapterIds(newBook.getChapterIds());
      return repository.save(book);
    }).orElseGet(() -> {
      newBook.setId(id);
      return repository.save(newBook);
    });
  }
}