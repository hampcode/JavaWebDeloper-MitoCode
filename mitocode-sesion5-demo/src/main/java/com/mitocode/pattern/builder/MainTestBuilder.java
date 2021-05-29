package com.mitocode.pattern.builder;

public class MainTestBuilder {
	public static void main(String[] args) {
		Task task = new TaskBuilder(5).setDescription("Hello").setSummary("Test").build();
		System.out.println(task);
	}

}
