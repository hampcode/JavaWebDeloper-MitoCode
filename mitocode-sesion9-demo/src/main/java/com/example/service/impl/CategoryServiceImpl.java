package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Category;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Long id, Category category) {
		
		Category categoryDetails = findById(id);

		category.setName(categoryDetails.getName());
		
		return categoryRepository.save(category);
	
	}

	@Override
	public void deleteCategory(Long categoryId) {
		
		categoryRepository.delete(findById(categoryId));
	}

	@Override
	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);

		if (!category.isPresent()) {
            throw new ResourceNotFoundException("There is no Category with ID = " + id);
        }

		return category.get();
	}

}
