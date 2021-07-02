package com.example.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OutcomeRequestUpdate {
	private Long outcomeId;
	
	@NotBlank
	@NotNull
	private String detail;
	
	@NotNull
	private BigDecimal amount;
}
