package com.mitocode.programstream;

import static com.mitocode.utils.DataUtils.getTasks;

import java.util.List;
import java.util.stream.Collectors;

import com.mitocode.entities.Task;
import com.mitocode.entities.TaskType;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Examples {

	public static void main(String[] args) {
		List<Task> tasks = getTasks();
		List<String> readingTasks=allReadingTasks(tasks);
		readingTasks.forEach(System.out::println);
		
		List<Task> distinctTasks = allDistinctTasks(tasks);
		distinctTasks.forEach(System.out::println);
		
		List<String> topNTasks=topN(tasks,3,1);
		topNTasks.forEach(System.out::println);
		
		long count=countAllReadingTasks(tasks);
		System.out.println(count);
		
		List<String> tasksDistinctTags=allDistinctTags(tasks);
		tasksDistinctTags.forEach(System.out::println);
		
		System.out.println(isAllReadingTasksWithTagBooks(tasks));
		System.out.println(isAnyReadingTasksWithTagJava8(tasks));
		System.out.println(joinAllTaskTitles(tasks));
	}

	// TODO Ejemplo 1: Encuentra todas los títulos de tareas de lectura ordenadas por la fecha de creación
	private static List<String> allReadingTasks(List<Task> tasks) {
		 return tasks.stream().
		            filter(task -> task.getType() == TaskType.READING).
		            sorted(comparing(Task::getCreatedOn).reversed()).
		            map(Task::getTitle).
		            collect(Collectors.toList());
	}
	
	//TODO Ejemplo 2: Encuentra tareas distintas
	public static List<Task> allDistinctTasks(List<Task> tasks) {
	    return tasks.stream().distinct().collect(toList());
	}
	
	//TODO Ejemplo 3: Encuentra la 5 primeras tareas de lectura ordenadas por fecha de creación
	// La página comienza en 0. Así que la segunda página (`page`) será 1 y la página n será n-1.
	public static List<String> topN(List<Task> tasks, int n, int page){
	    return  tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                sorted(comparing(Task::getCreatedOn).reversed()).
                map(Task::getTitle).
                skip(page * n). //obtenemos los productos a partir del page*n (inclusive)
                limit(n).
                collect(toList());
	}
	
	//TODO: Ejemplo 4: Cuenta todas las tareas de lectura
	public static long countAllReadingTasks(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            count();
	}
	
	//TODO: Ejemplo 5: Encuentra todas las etiquetas únicas de todas las tareas
	private static List<String> allDistinctTags(List<Task> tasks) {
        return tasks.stream()
        		.flatMap(task -> task.getTags()
        			.stream())
        			.distinct()
        			.collect(toList());
	}
	
	//TODO: Ejemplo 6: Comprueba si todas las tareas de lectura tienen la etiqueta books
	public static boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            allMatch(task -> task.getTags().contains("books"));
	}

	public static boolean isAnyReadingTasksWithTagJava8(List<Task> tasks) {
	    return tasks.stream().
	            filter(task -> task.getType() == TaskType.READING).
	            anyMatch(task -> task.getTags().contains("java8"));
	}
	
	//TODO: Ejemplo 7: Crear un resumen de todos los títulos
	// La función reduce() toma un lambda que une los elementos del flujo.
	public static String joinAllTaskTitles(List<Task> tasks) {
	    return tasks.stream().
	            map(Task::getTitle).
	            reduce((first, second) -> first + " *** " + second).
	            get();
	}
}
