package com.mitocode.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mitocode.model.Product;
import com.mitocode.service.CalculationService;

public class ProgramGeneric2 {

	public static void main(String[] args) {
		
		List<Product> list=new ArrayList<Product>();
		
		String path="/Users/hamp/Documents/JavaWebDeloper-MitoCode/mitocode-sesion2-demo01/int.txt";
		
		try(BufferedReader br=new BufferedReader(new FileReader(path))) {
			
			String line=br.readLine();
			while (line!=null) {
				String[] fields=line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line=br.readLine();
				
			}
			Product productPriceMax= CalculationService.max(list);
			System.out.println("Max:");
			System.out.println(productPriceMax);
		} catch (IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
