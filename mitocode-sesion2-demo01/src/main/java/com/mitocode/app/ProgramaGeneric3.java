package com.mitocode.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.mitocode.model.Circle;
import com.mitocode.model.Rectangle;
import com.mitocode.model.Shape;

public class ProgramaGeneric3 {

	public static void main(String[] args) { 
		List<Integer> myInts = Arrays.asList(5, 2, 10); 		
		printList(myInts); 
		List<String> myStrs = Arrays.asList("Maria","Alex"); 		
		printList(myStrs); 
		
		List<?> list = new ArrayList<>(); 
		//list.add(3); // error compilación
		
		List<Shape> myShapes=new ArrayList<>();
		myShapes.add(new Rectangle(3.0, 2.0));
		myShapes.add(new Circle(2.0));
		System.out.println("Total area: "+totalArea(myShapes));
		
		List<Circle> myCircles=new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		System.out.println("Total area: "+totalArea(myShapes));

	} 

	public static void printList(List<?> list) { 
		for (Object obj : list) { 
		  System.out.println(obj); 
		}
	} 

	public static double totalArea(List<? extends Shape> list) {
		double sum=0.0;
		for(Shape s:list) {
			sum+=s.area();
		}
		return sum;
	}
}
