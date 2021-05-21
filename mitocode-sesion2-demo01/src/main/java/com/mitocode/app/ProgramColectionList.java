package com.mitocode.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mitocode.model.Employee;

public class ProgramColectionList {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		List<Employee> employees=new ArrayList<>();
		
		//PART 1: READING DATA
		System.out.println("How many employees will be registered?");
		int n=sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			System.out.println();
			System.out.println("Employee #"+i+": ");
			
			System.out.println("Id: ");
			int id=sc.nextInt();
			while(hasId(employees, id)) {
				System.out.println("Id already taken. Try again:");
				id=sc.nextInt();
			}
			
			System.out.println("Name: ");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Salary: ");
			double salary=sc.nextDouble();
			employees.add(new Employee(id, name, salary));
		}
		
		//PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE
		System.out.println();
		System.out.println("Enter the employee id that will have salary increase: ");
		int id=sc.nextInt();
		Employee employeById=employees
				 .stream()
				 .filter(emp->emp.getId()==id)
				 .findFirst()
				 .orElse(null);
		if(employeById==null) {
			System.out.println("This is does not exist!");
		}else {
			System.out.println("Enter the percentage:");
			double percentage=sc.nextDouble();
			employeById.increaseSalary(percentage);
		}
		
		//PART 3 - LISTING EMPLOYEES
		System.out.println();
		System.out.println("List of employees");
		for(Employee employee: employees) {
			System.out.println(employee);
		}
		
		sc.close();
	}

	
	public static boolean hasId(List<Employee> employees, int id) {
		Employee employee=employees
				     .stream()
				     .filter(emp->emp.getId()==id)
				     .findFirst()
				     .orElse(null);
		return employee!=null;
	}
}
