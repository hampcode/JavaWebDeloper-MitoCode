package com.mitocode.service;

public interface OnlinePaymentService {
	double paymentsFee(double amount);
	double interest(double amount, int months);
}
