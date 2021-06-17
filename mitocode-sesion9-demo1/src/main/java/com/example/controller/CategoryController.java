package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entities.Book;
import com.example.entities.Category;
import com.example.service.CategoryService;

import java.util.List;


@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = "/category/create")
	public String newCatForm(Model model) {
		model.addAttribute("category", new Category());
		return "categories/new";
	}

	@RequestMapping(path = "/category", method = RequestMethod.POST)
	public String saveNewCategory(Category category) {
		long id = categoryService.create(category);
		return "redirect:/categories";
	}

	@GetMapping("/category/{id}")
	public String editCategoryForm(@PathVariable("id") long id, Model model) {
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "categories/edit";
	}

	@GetMapping("/category/books/{id}")
	public String showBooksByCategory(@PathVariable("id") long category_id, Model model) {
		Category category = categoryService.findById(category_id);
		List<Book> books = category.getBooks();
		model.addAttribute("category", category);
		model.addAttribute("books", books);
		return "categories/showById";
	}

	@GetMapping("/categories")
	public String showAllCategories(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "categories/list";
	}

	@RequestMapping(path = "/category/{id}", method = RequestMethod.POST)
	public String updateCategory(@PathVariable("id") long id, Category category) {
		categoryService.update(id, category);
		return "redirect:/categories";
	}

	@RequestMapping(path = "/category/delete/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") long id) {
		categoryService.delete(id);
		return "redirect:/categories";
	}
}