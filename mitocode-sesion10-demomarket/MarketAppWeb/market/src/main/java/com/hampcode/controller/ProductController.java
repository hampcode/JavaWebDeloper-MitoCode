package com.hampcode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hampcode.model.domain.Product;
import com.hampcode.service.impl.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/loadproducts/{term}", produces = { "application/json" })
	public @ResponseBody List<Product> loadProducos(@PathVariable String term) {
		List<Product> products=new ArrayList<>();
		try {
			products=productService.getProductByName(term);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
