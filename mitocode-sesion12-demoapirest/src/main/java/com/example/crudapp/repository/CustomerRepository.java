package com.example.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudapp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}