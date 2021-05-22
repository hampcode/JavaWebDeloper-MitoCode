package com.mitocode.lambda3.util;

import java.util.function.Consumer;


import com.mitocode.lambda3.entities.Product;

public class PriceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}
}