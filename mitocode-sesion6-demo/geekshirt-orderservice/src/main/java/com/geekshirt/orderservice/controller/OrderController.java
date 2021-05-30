package com.geekshirt.orderservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geekshirt.orderservice.dto.OrderResponse;

@RestController
public class OrderController {
	
	@GetMapping("order")
	public ResponseEntity<List<OrderResponse>> findAll(){
		List<OrderResponse> orders=new ArrayList<>();
		
		OrderResponse response=new OrderResponse();
		response.setAccountId("1");
		response.setOrderId("1234");
		response.setStatus("PENDING");
		response.setTotalAmount(100.00);
		response.setTotalTax(10.00);
		response.setTransactionDate(new Date());
		
		orders.add(response);
		
		return new ResponseEntity<List<OrderResponse>>(orders, HttpStatus.OK);
	}
}
