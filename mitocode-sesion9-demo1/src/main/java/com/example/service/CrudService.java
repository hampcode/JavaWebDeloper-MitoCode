package com.example.service;

import java.util.List;

public interface CrudService<T, ID> {
	List<T> getAll();

	T findById(ID id);

	Long create(T t);

	void update(ID id, T t);

	void delete(ID id);
}