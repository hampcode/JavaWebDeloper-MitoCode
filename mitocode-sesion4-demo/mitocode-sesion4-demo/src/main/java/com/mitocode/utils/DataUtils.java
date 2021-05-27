package com.mitocode.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.mitocode.entities.Product;
import com.mitocode.entities.Task;
import com.mitocode.entities.TaskType;

import static java.util.stream.Collectors.toList;

public class DataUtils {
	public static List<Task> getTasks() {
		Task task1 = new Task("Read Java 8 in action", TaskType.READING, LocalDate.of(2015, Month.SEPTEMBER, 20))
				.addTag("java").addTag("java8").addTag("books");
		Task task2 = new Task("Write factorial program in Haskell", TaskType.CODING,
				LocalDate.of(2015, Month.SEPTEMBER, 20)).addTag("program").addTag("haskell").addTag("functional");
		Task task3 = new Task("Read Effective Java", TaskType.READING, LocalDate.of(2015, Month.SEPTEMBER, 21))
				.addTag("java").addTag("books");
		Task task4 = new Task("Write a blog on Stream API", TaskType.BLOGGING, LocalDate.of(2015, Month.SEPTEMBER, 21))
				.addTag("writing").addTag("stream").addTag("java8");
		Task task5 = new Task("Write prime number program in Scala", TaskType.CODING,
				LocalDate.of(2015, Month.SEPTEMBER, 22)).addTag("scala").addTag("functional").addTag("program");
		return Stream.of(task1, task2, task3, task4, task5).collect(toList());
	}

	public static List<Product> getProducts() {

		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Product1", 1, 1, 18.00, 39));
		products.add(new Product(2, "Product2", 1, 2, 19.00, 40));
		products.add(new Product(3, "Product3", 2, 1, 20.00, 10));
		products.add(new Product(4, "Product4", 2, 2, 30.00, 20));
		products.add(new Product(5, "Product5", 3, 1, 20.00, 30));
		products.add(new Product(6, "Product6", 3, 2, 15.00, 15));

		return products;

	}

}
