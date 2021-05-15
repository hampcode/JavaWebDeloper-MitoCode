package com.mitocode.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitocode.model.Company;
import com.mitocode.model.Individual;
import com.mitocode.model.TaxPayer;

public class ProgramHerencia {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Type ==> TaxPayer
		List<TaxPayer> taxs=new ArrayList<>();
		
		System.out.println("Enter number of taxpayers:");
		int quantityTaxPayer=sc.nextInt();
		
		for (int i = 1; i <=quantityTaxPayer ; i++) {
			System.out.println("Taxpayer # "+i+" data:");
			System.out.println("Individual or company (i/c)?");
			char type=sc.next().charAt(0);
			System.out.println("Name:");
			String name=sc.next();
			System.out.println("Anual Income:");
			Double anualIncome=sc.nextDouble();
			//Factory Patterns (TODO)
			if(type=='i') {
				System.out.println("Health expenditures");
				Double healthExpenditures=sc.nextDouble();
				taxs.add(new Individual(name, anualIncome, healthExpenditures));
			}else {
				System.out.println("Number of employees");
				Integer numberOfEmployees=sc.nextInt();
				taxs.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println();
		System.err.println("TAXES PAID");
		for (TaxPayer taxPayer : taxs) {
			System.out.println(taxPayer.getName()+":$ "+ String.format("%.2f",taxPayer.tax()));
		}
		
		System.out.println();
		double sum=0.0;
		for (TaxPayer taxPayer2 : taxs) {
			sum+=taxPayer2.tax();
		}
		System.out.println("TOTAL TAXES: $"+ String.format("%.2f",sum));
		sc.close();
	}
}
