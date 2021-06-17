package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entities.Book;

import java.util.List;

@Service
public interface BookService extends CrudService<Book, Long> {

	List<Book> getAll();

	Book findById(Long bookId);

	Long create(Book bookDetails);

	void update(Long bookId, Book bookDetails);

	void delete(Long bookId);

}