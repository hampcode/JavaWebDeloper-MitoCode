package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.entities.Book;
import com.example.entities.Category;
import com.example.service.BookService;
import com.example.service.CategoryService;

import java.util.List;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = "/book/show/{id}")
	public String showSingleBook(@PathVariable("id") long id, Model model) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		return "books/showById";
	}

	@RequestMapping(path = "/book/create")
	public String newBookForm(Model model) {
		model.addAttribute("book", new Book());
		List<Category> categories = categoryService.getAll();
		model.addAttribute("categories", categories);
		return "books/new";
	}

	@RequestMapping(path = "/book", method = RequestMethod.POST)
	public String saveNewBook(Book book) {
		long id = bookService.create(book);
		return "redirect:/books";
	}

	@GetMapping("/book/{id}")
	public String editBookForm(@PathVariable("id") long id, Model model) {
		Book book = bookService.findById(id);
		List<Category> categories = categoryService.getAll();
		model.addAttribute("allCategories", categories);
		model.addAttribute("book", book);
		return "books/edit";
	}

	@GetMapping({ "/books", "/" })
	public String showAllBooks(Model model) {
		model.addAttribute("books", bookService.getAll());
		model.addAttribute("categories", categoryService.getAll());
		return "index";
	}

	@RequestMapping(path = "/book/{id}", method = RequestMethod.POST)
	public String updateBook(@PathVariable("id") long id, Book book) {
		bookService.update(id, book);
		return "redirect:/books";
	}

	@RequestMapping(path = "/book/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") long id) {
		bookService.delete(id);
		return "redirect:/books";
	}
}
