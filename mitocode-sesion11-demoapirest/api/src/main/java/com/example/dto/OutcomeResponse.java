package com.example.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class OutcomeResponse {
	private Long outcomeId;
	private String detail;
	private BigDecimal amount;
	private Date createdAt;
	private Date updatedAt;
}
