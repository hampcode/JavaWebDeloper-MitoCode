package com.hampcode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T> {

	List<T> getAll() throws Exception;

	Page<T> getAll(Pageable pageable) throws Exception;
	
	T saveOrUpdate(T entity) throws Exception;

	Optional<T> getOne(Long id) throws Exception;

	void deleteById(Long id) throws Exception;
}
