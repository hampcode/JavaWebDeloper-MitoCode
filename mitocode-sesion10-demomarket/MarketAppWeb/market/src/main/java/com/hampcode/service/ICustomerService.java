package com.hampcode.service;


import java.util.List;

import com.hampcode.model.domain.Customer;

public interface ICustomerService extends CrudService<Customer> {

	List<Customer> getCustomerByDni(String dni) throws Exception;

	

}
