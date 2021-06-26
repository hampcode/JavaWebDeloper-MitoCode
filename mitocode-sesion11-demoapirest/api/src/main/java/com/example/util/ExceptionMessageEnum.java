package com.example.util;

public enum ExceptionMessageEnum {

	OUTCOME_OUT_FOUND("Outcome not found"),
	INCORRECT_REQUEST_EMPTY_ITEMS_OUTCOME("Empty item are not allowed in the outcome");
	
	private final String value;
	
	ExceptionMessageEnum(String message) {
		value=message;
	}

	public String getValue() {
		return value;
	}
	
	
}
