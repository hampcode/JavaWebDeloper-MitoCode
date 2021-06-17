package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		List<Category> categorySet = new ArrayList<>();
		categoryRepository.findAll().forEach(categorySet::add);
		return categorySet;
	}

	@Override
	public Category findById(Long catId) {
		Optional<Category> categoryOptional = categoryRepository.findById(catId);

		if (!categoryOptional.isPresent()) {
			throw new RuntimeException("Category Not Found!");
		}
		return categoryOptional.get();
	}

	@Override
	public void delete(Long catId) {
		categoryRepository.deleteById(catId);
	}

	@Override
	public Long create(Category categoryDetails) {
		categoryRepository.save(categoryDetails);
		return categoryDetails.getId();
	}

	@Override
	public void update(Long catId, Category categoryDetails) {
		Category currentCat = findById(catId);
		currentCat.setName(categoryDetails.getName());

		categoryRepository.save(currentCat);
	}

}