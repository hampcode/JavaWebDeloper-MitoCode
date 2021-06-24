package com.hampcode.service;

import java.util.List;

import com.hampcode.model.domain.Product;

public interface IProductService extends CrudService<Product> {
	List<Product> getProductByName(String name) throws Exception;
}
