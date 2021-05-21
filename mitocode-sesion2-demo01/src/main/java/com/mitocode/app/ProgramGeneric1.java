package com.mitocode.app;

import java.util.Scanner;

import com.mitocode.service.PrintService;

public class ProgramGeneric1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		PrintService<Integer> ps=new PrintService<Integer>();
		
		System.out.print("How many value? ");
		int n=sc.nextInt();
		
		ps.addValue(1);
		
		for (int i = 0; i < n; i++) {
			ps.addValue(sc.nextInt());
		}
		
		ps.print();
		System.out.println("Firt: "+ps.first());

		sc.close();
	}

}
