package com.mitocode.programoptional;

import com.mitocode.programoptional.entities.Task;
import com.mitocode.programoptional.exception.TaskNotFoundException;
import com.mitocode.programoptional.repository.TaskRepository;

public class Program {
	
	private static TaskRepository taskRepository=new TaskRepository();
	
	public static void main(String[] args) {
		System.out.println(taskTitle("1"));
		System.out.println(taskAssignedTo("1"));
	}

	//Obtener el nombre del usuario asignado
	public static String taskAssignedTo(String taskId) {
		  return taskRepository.
		    find(taskId).
		    flatMap(task -> task.getAssignedTo().map(user -> user.getUsername())).
		    orElse("NotAssigned");
	}
	
	//Obtener el título de una tarea
	public static String taskTitle(String taskId) {
	    return taskRepository.
	        find(taskId).
	        map(Task::getTitle).
	        orElseThrow(() -> new TaskNotFoundException(String.format("No task exist for id '%s'",taskId)));
	}
}
