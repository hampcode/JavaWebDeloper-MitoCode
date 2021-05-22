package com.mitocode.concepfuncional.app;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.lambda1.entities.Product;

public class ProgramTipadoDinamico {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

		list.forEach(System.out::println);
	}

}
