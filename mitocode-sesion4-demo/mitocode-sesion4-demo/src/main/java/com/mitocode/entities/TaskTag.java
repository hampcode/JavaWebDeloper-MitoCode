package com.mitocode.entities;

public class TaskTag {
	private String tag;
	private Task task;
	
	public TaskTag(String tag, Task task) {
        this.tag = tag;
        this.task = task;
    }


	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getTag() {
		return tag;
	}

	public Task getTask() {
		return task;
	}
}
