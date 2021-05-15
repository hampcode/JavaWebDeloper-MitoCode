package com.mitocode.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mitocode.model.Contract;
import com.mitocode.model.Installment;
import com.mitocode.service.impl.ContractService;
import com.mitocode.service.impl.PaypalService;
import com.mitocode.service.impl.StripeService;

public class ProgramInterface {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter contract data");
		System.out.println("Number");
		Integer number=sc.nextInt();
		System.out.println("Date (dd/MM/yyyy)");
		Date date=formatDate.parse(sc.next());
		System.out.println("Contract value");
		Double totalValue=sc.nextDouble();
		
		Contract contract=new Contract(number, date, totalValue);
		
		System.out.println("Enter number of intallments");
		int quantityInstallment=sc.nextInt();
		
		ContractService contractService=new ContractService(new StripeService());
		contractService.processContract(contract, quantityInstallment);
		
		System.out.println("Installments");
		for (Installment installment : contract.getInstallments()) {
			System.out.println(installment);
		}
		
		sc.close();

	}

}
