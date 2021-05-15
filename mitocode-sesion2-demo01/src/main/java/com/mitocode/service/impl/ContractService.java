package com.mitocode.service.impl;

import java.util.Calendar;
import java.util.Date;

import com.mitocode.model.Contract;
import com.mitocode.model.Installment;
import com.mitocode.service.OnlinePaymentService;

public class ContractService {

	/*private PaypalService paypalService=new PaypalService();
	private StripeService stripeService=new StripeService();*/
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService=onlinePaymentService;
	}
	
	public void processContract(Contract contract,int months) {
		
		double basicQuota=contract.getTotalValue()/months;
		for (int i = 1; i <=months; i++) {
			//double updateQuota=basicQuota+stripeService.interest(basicQuota, i);
			double updateQuota=basicQuota+onlinePaymentService.interest(basicQuota, i);
			//double fullQuota=basicQuota+stripeService.paymentsFee(updateQuota);
			double fullQuota=basicQuota+onlinePaymentService.paymentsFee(updateQuota);
			Date dueDate=addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate,fullQuota));
		}
		
	}
	
	private Date addMonths(Date date, int numberQuates) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, numberQuates);
		return calendar.getTime();
	}
}
