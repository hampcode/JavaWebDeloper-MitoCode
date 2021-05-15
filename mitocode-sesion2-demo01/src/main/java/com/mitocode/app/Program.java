package com.mitocode.app;

import java.util.Scanner;

import com.mitocode.model.Client;
import com.mitocode.model.Order;
import com.mitocode.model.OrderItem;
import com.mitocode.model.Product;
import com.mitocode.model.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.println("Name:");
		String name=sc.nextLine();
		System.out.println("Email:");
		String email=sc.nextLine();
		
		Client client=new Client(name, email);
		
		System.out.println("Enter order data");
		System.out.print("Status");
		OrderStatus status=OrderStatus.valueOf(sc.next());
		
		Order order=new Order(status,client);
		
		System.out.println("How many item to this order?");
		int quantityItems=sc.nextInt();
		
		for (int i = 1; i <=quantityItems; i++) {
			System.out.println("Enter #"+i+" item data");
			System.out.println("Product name:");
			sc.nextLine();
			String productName=sc.nextLine();
			System.out.println("Product price:");			
			double productPrice=sc.nextDouble();
			System.out.println("Quantity:");			
			int quantity=sc.nextInt();
			
			Product product=new Product(productName, productPrice);
			
			OrderItem item=new OrderItem(quantity, productPrice, product);
			
			order.addItem(item);			
		}
		
		System.out.println();
		System.out.println(order);
		sc.close();
		
	}
}







