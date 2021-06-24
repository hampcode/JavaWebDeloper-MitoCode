package com.hampcode.model.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hampcode.model.domain.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	List<Customer> findByDni(String dni);

}