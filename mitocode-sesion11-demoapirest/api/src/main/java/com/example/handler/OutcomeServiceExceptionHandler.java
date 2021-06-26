package com.example.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.exception.IncorrectOutcomeRequestException;
import com.example.exception.OutcomeExceptionResponse;
import com.example.exception.OutcomeNotFoundException;

@ControllerAdvice
public class OutcomeServiceExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception exception, WebRequest request){
		OutcomeExceptionResponse response=new OutcomeExceptionResponse
				(exception.getMessage(), request.getDescription(false), 
						HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
		
		return new ResponseEntity<>(response, response.getStatus());
	}
	
	
	@ExceptionHandler(IncorrectOutcomeRequestException.class)
	public ResponseEntity<Object> handleIncorrectRequest(Exception exception, WebRequest request){
		OutcomeExceptionResponse response=new OutcomeExceptionResponse
				(exception.getMessage(), request.getDescription(false), 
						HttpStatus.BAD_REQUEST, LocalDateTime.now());
		
		return new ResponseEntity<>(response, response.getStatus());
	}

	@ExceptionHandler(OutcomeNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(Exception exception, WebRequest request){
		OutcomeExceptionResponse response=new OutcomeExceptionResponse
				(exception.getMessage(), request.getDescription(false), 
						HttpStatus.NOT_FOUND, LocalDateTime.now());
		
		return new ResponseEntity<>(response, response.getStatus());
	}

}
