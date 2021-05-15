package com.mitocode.service.impl;

import com.mitocode.service.OnlinePaymentService;

public class StripeService implements OnlinePaymentService{

	private static final double STRIPE_FEE=0.12;
	private static final double MONTHLY_INTEREST=0.04;

	@Override
	public double paymentsFee(double amount) {
		return amount*STRIPE_FEE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount*months*MONTHLY_INTEREST;
	}

}
