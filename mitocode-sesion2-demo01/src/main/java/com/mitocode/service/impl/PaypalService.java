package com.mitocode.service.impl;

import com.mitocode.service.OnlinePaymentService;

public class PaypalService implements OnlinePaymentService {
	
	private static final double PAYMENT_FEE=0.02;
	private static final double MONTHLY_INTEREST=0.01;

	@Override
	public double paymentsFee(double amount) { 
		return amount*PAYMENT_FEE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount*months*MONTHLY_INTEREST;
	}

}
