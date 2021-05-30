package com.geekshirt.orderservice.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
	private String orderId;
	private String status;
	private String accountId;
	private Double totalAmount;
	private Double totalTax;
	private Date transactionDate;

}
