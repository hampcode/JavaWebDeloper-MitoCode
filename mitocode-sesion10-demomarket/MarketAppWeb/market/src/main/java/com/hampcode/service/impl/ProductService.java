package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hampcode.model.domain.Product;
import com.hampcode.model.repository.ProductRepository;
import com.hampcode.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() throws Exception {
		return productRepository.findAll();
	}

	@Override
	public Page<Product> getAll(Pageable pageable) throws Exception {
		return productRepository.findAll(pageable);
	}

	@Override
	public Product saveOrUpdate(Product entity) throws Exception {
		return productRepository.save(entity);
	}

	@Override
	public Optional<Product> getOne(Long id) throws Exception {
		return productRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getProductByName(String name) throws Exception {
		return productRepository.findByNameContaint(name);
	}

}
