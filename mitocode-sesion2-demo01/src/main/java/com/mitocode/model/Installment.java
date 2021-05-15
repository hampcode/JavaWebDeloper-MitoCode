package com.mitocode.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	private static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

	private Date dueDate;
	private Double amount;

	public Installment() {
		super();
	}

	public Installment(Date dueDate, Double amount) {
		super();
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Installment [dueDate=" + formatDate.format(dueDate) + ","
				+ " amount=" + String.format("%.2f", amount) + "]";
	}
	
}
