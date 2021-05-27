package com.mitocode.entities;

public class Product {
	private int id;
	private String name;
	private int supplier;
	private int category;
	private double unitPrice;
	private int unitsInStock;

	public Product() {
		super();
	}

	public Product(int id, String name, int supplier, int category, double unitPrice, int unitsInStock) {
		super();
		this.id = id;
		this.name = name;
		this.supplier = supplier;
		this.category = category;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSupplier() {
		return supplier;
	}

	public void setSupplier(int supplier) {
		this.supplier = supplier;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name='" + name + '\'' + ", supplier=" + supplier + ", category=" + category
				+ ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock + '}';
	}
}
