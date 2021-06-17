package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entities.Category;

import java.util.List;

@Service
public interface CategoryService extends CrudService<Category, Long> {

	List<Category> getAll();

	Category findById(Long catId);

	Long create(Category categoryDetails);

	void update(Long catId, Category categoryDetails);

	void delete(Long catId);
}