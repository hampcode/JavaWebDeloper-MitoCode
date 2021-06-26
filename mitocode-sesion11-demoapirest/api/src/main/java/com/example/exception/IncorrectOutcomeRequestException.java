package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IncorrectOutcomeRequestException extends RuntimeException{

	public IncorrectOutcomeRequestException(String message) {
		super(message);
	}
}
