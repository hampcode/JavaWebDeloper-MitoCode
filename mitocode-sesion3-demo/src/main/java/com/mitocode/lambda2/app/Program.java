package com.mitocode.lambda2.app;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.lambda2.entities.Product;



public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		list.removeIf(Product::nonStaticProductPredicate);

		for (Product p : list) {
			System.out.println(p);
		}
	}
}