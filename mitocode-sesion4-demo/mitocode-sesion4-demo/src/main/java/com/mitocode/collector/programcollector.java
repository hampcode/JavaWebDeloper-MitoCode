package com.mitocode.collector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.mitocode.entities.Product;
import com.mitocode.entities.Task;
import com.mitocode.entities.TaskType;

import static com.mitocode.utils.DataUtils.getTasks;
import static com.mitocode.utils.DataUtils.getProducts;

public class programcollector {
	public static void main(String[] args) {
		List<Product> products = getProducts();
		
		//Para conseguir lo mismo en Java 7 habría que escribir el siguiente código:
		List<Task> tasks = getTasks();
	    Map<TaskType, List<Task>> allTasksByType = new HashMap<>();
	    for (Task task : tasks) {
	        List<Task> existingTasksByType = allTasksByType.get(task.getType());
	        if (existingTasksByType == null) {
	            List<Task> tasksByType = new ArrayList<>();
	            tasksByType.add(task);
	            allTasksByType.put(task.getType(), tasksByType);
	        } else {
	            existingTasksByType.add(task);
	        }
	    }
	    for (Map.Entry<TaskType, List<Task>> entry : allTasksByType.entrySet()) {
	        System.out.println(String.format("%s =>> %s", entry.getKey(), entry.getValue()));
	    }
	    
	    Map<TaskType, List<Task>> tasksByType=groupTasksByType(tasks);
	    tasksByType.forEach((type, task) -> System.out.printf("tasktype: %s: tasks: %s \n", type,task));
	    
	    
		//groupingBy 
	    getFilterProductoGroupingByStock(products).forEach((unidades, producto) -> System.out.printf("Stock: %s Productos: %s \n", unidades, producto));
		
		//counting
	    getCountingProductoGroupingBySupplier(products).forEach((s, c) -> System.out.printf("proveedor: %s: productos: %s \n", s,c));
		
		//Collectors.summarizingDouble/Long/Int()
	    getSummatizingUnitPriceGroupingByStock(products).forEach((stock, suma) -> System.out.printf("en stock: %s: precio total: %s \n", stock,suma));
		
		
		//Collectors.averagingDouble/Long/Int()
	    Double average =getAveragingStock(products); 
	    System.out.printf("Promedio de stok en almacen::"+average);
		
		
	    System.out.println(getMaxUnitPriceProduct(products).get());
		
	    System.out.println( getStatisticsUnitPrice(products));
	    
	}

	// TODO:Collector en Acción
	//Para demostrar el poder de Collector vamos a observar el ejemplo donde tenemos que agrupar tareas por su tipo.
	private static Map<TaskType, List<Task>> groupTasksByType(List<Task> tasks) {
		return tasks.stream().collect(Collectors.groupingBy(task -> task.getType()));
	}

	//TODO: Recoger datos en un conjunto
	//Vamos a escribir nuestro primer caso de prueba: dada una lista de tareas queremos recoger sus títulos en una lista.
	//Recoger datos en una lista
	public static List<String> allTitles(List<Task> tasks) {
        return tasks.stream().map(Task::getTitle).collect(Collectors.toList());
    }
	
	//TODO:Recoger datos en un conjunto
	//Si queremos estar seguros de que sólo recogemos títulos únicos y no nos preocupa el orden, podemos usar el acumulador toSet().
	public static Set<String> uniqueTitles(List<Task> tasks) {
	    return tasks.stream().map(Task::getTitle).collect(Collectors.toSet());
	}
		
	//TODO: Productos
	//groupingBy 
		public static Map<Integer, List<Product>>  getFilterProductoGroupingByStock(List<Product> products)  {
				Map<Integer, List<Product>> collect = products.stream()
				        .filter(p -> p.getUnitsInStock() < 20)
				        .collect(Collectors.groupingBy(Product::getUnitsInStock));

				
				return collect;
		}


		//counting
		public static Map<Integer, Long>  getCountingProductoGroupingBySupplier(List<Product> products)  {
			
			Map<Integer, Long> collect = products.stream()
			        .collect( //en el metodo collect se especifican las funciones de agregacion
			                Collectors.groupingBy( // deseamos agrupar
			                        Product::getSupplier, // agrupamos por proveedor
			                        Collectors.counting() // realizamos el conteo
			                    )
			                );
			
			return collect;
		}
		
		
		//Collectors.summarizingDouble/Long/Int()
		public static Map<Integer, Double> getSummatizingUnitPriceGroupingByStock(List<Product> products)  {
				
			  Map<Integer, Double> collect = products.stream()
			        .collect( //en el metodo collect se especifican las funciones de agregacion
			                Collectors.groupingBy( // deseamos agrupar
			                        Product::getUnitsInStock, //agrupamos por existencias en stock
			                        Collectors.summingDouble( //el tipo de dato a sumar es double
			                                Product::getUnitPrice //sumamos el precio unitario
			                        )
			                )
			        );
			        
				
				return collect;
		}
		
		public static DoubleSummaryStatistics getStatisticsUnitPrice(List<Product> products)  {
			
			DoubleSummaryStatistics statistics =
		            products.stream().collect(Collectors.summarizingDouble(Product::getUnitPrice));
				
				return statistics;
		}
		
		
		
		//Collectors.averagingDouble/Long/Int()
		public static Double getAveragingStock(List<Product> products)  {
					
			Double average = products.stream()
	                .collect(Collectors.averagingInt(Product::getUnitsInStock));
					
					return average;
		}
		
		
		//Collectors.max()/min()
		public static Optional<Product> getMaxUnitPriceProduct(List<Product> products)  {
			
			Optional<Product> product = products.stream().max(Comparator.comparing(Product::getUnitPrice));
			
			return product;
			
		}
	
	
	
}
