package com.mitocode.model;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.model.enums.OrderStatus;

public class Order {

	private OrderStatus status;
	private Client client;

	// Composition
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
		
	}

	public Order(OrderStatus status, Client client) {
		this.status = status;
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double suma=0.0;
		for (OrderItem orderItem : items) {
			suma+=orderItem.subTotal();
		}
		return suma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Order status:");
		sb.append(this.status +"\n");
		sb.append("Client:");
		sb.append(this.client +"\n");
		sb.append("Order items:");		
		for (OrderItem orderItem : items) {			
			sb.append(orderItem +"\n");
		}		
		sb.append("Total price $:");
		sb.append(String.format("%.2f", this.total()));
		return sb.toString();
	}
}




