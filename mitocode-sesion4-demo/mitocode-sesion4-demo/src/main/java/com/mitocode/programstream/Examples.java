package com.mitocode.programstream;

import static com.mitocode.utils.DataUtils.getTasks;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mitocode.entities.Task;
import com.mitocode.entities.TaskType;

public class Examples {

	public static void main(String[] args) {
		List<Task> tasks = getTasks();
		List<String> readingTasks=allReadingTasks(tasks);
		readingTasks.forEach(System.out::println);
		
		List<Task> distinctTasks = allDistinctTasks(tasks);
		distinctTasks.forEach(System.out::println);
	}

	// TODO Ejemplo 1: Encuentra todas los títulos de tareas de lectura ordenadas por la fecha de creación
	private static List<String> allReadingTasks(List<Task> tasks) {
		 return tasks.stream().
		            filter(task -> task.getType() == TaskType.READING).
		            sorted(Comparator.comparing(Task::getCreatedOn).reversed()).
		            map(Task::getTitle).
		            collect(Collectors.toList());
	}
	
	//TODO Ejemplo 2: Encuentra tareas distintas
	public static List<Task> allDistinctTasks(List<Task> tasks) {
	    return tasks.stream().distinct().collect(Collectors.toList());
	}

}
