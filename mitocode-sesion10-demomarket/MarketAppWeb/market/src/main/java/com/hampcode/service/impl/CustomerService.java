package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hampcode.model.domain.Customer;
import com.hampcode.model.repository.CustomerRepository;
import com.hampcode.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() throws Exception {
		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Page<Customer> getAll(Pageable pageable) throws Exception {
		return customerRepository.findAll(pageable);
	}
	
	@Override
	public Customer saveOrUpdate(Customer entity) throws Exception {
		return customerRepository.save(entity);
	}

	@Override
	public Optional<Customer> getOne(Long id) throws Exception {
		return customerRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> getCustomerByDni(String dni) throws Exception {
		return customerRepository.findByDni(dni);
	}

	/*@Override
	public Optional<Customer> getCustomerByIdWithInvoices(Long customerId) throws Exception {
		return customerRepository.findCustomerByIdWithInvoices(customerId);
	}*/

	

}
