package com.mitocode.lambda4.util;

import java.util.function.Function;

import com.mitocode.lambda4.entities.Product;

public class UpperCaseName implements Function<Product, String> {

	@Override
	public String apply(Product p) {
		return p.getName().toUpperCase();
	}
}