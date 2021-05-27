package com.mitocode.programoptional.exception;

public class TaskNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(String id) {
		super("No task found for id: " + id);
	}
}
