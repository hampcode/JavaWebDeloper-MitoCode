package com.mitocode.lambda2.util;

import java.util.function.Predicate;

import com.mitocode.lambda1.entities.Product;

public class ProductPredicate implements Predicate<Product> {

	@Override
	public boolean test(Product p) {
		return p.getPrice() >= 100.0;
	}
}