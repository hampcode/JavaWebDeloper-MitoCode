package com.mitocode.app;

import java.util.Scanner;

import com.mitocode.service.PrintService;
import com.mitocode.service.PrintServiceString;

public class ProgramGeneric1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		PrintService ps=new PrintService();
		
		
		System.out.print("How many value? ");
		int n=sc.nextInt();
		
		ps.addValue(String.valueOf(1));
		
		for (int i = 0; i < n; i++) {
			String value=sc.next();
			ps.addValue(value);
		}
		
		ps.print();
		String firstValue=(String)ps.first();
		System.out.println("Firt: "+firstValue);

		sc.close();
	}

}
