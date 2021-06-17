package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAll() {
		List<Book> bookSet = new ArrayList<>();
		bookRepository.findAll().forEach(bookSet::add);
		return bookSet;
	}

	@Override
	public Book findById(Long bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);

		if (!bookOptional.isPresent()) {
			throw new RuntimeException("Book Not Found!");
		}
		return bookOptional.get();
	}

	@Override
	public void update(Long bookId, Book bookDetails) {
		Book currentBook = findById(bookId);
		currentBook.setTitle(bookDetails.getTitle());
		currentBook.setAuthor(bookDetails.getAuthor());
		currentBook.setCategories(bookDetails.getCategories());
		currentBook.setDescription(bookDetails.getDescription());
		currentBook.setDateField(bookDetails.getDateField());

		bookRepository.save(currentBook);
	}

	@Override
	public void delete(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public Long create(Book bookDetails) {
		bookRepository.save(bookDetails);
		return bookDetails.getId();
	}
}