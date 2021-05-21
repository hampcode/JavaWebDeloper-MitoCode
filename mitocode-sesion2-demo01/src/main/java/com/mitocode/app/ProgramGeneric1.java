package com.mitocode.app;

import java.util.Scanner;

import com.mitocode.service.PrintService;
import com.mitocode.service.PrintServiceString;

public class ProgramGeneric1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		//PrintService ps=new PrintService();
		PrintServiceString ps=new PrintServiceString();
		
		System.out.print("How many value? ");
		int n=sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			//Integer value=sc.nextInt();
			String value=sc.next();
			ps.addValue(value);
		}
		
		ps.print();
		//Integer firstValue=ps.first();
		String firstValue=ps.first();
		System.out.println("Firt: "+firstValue);

		sc.close();
	}

}
