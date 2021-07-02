package com.example.crudapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudapp.model.Customer;
import com.example.crudapp.model.Message;
import com.example.crudapp.service.CustomerServices;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerServices customerServices;
	
	//@PostMapping("/create")
	@PostMapping
	public ResponseEntity<Message> addNewCustomer(@RequestBody Customer customer) {
		try {
			Customer returnedCustomer = customerServices.saveCustomer(customer);
			
			return new ResponseEntity<Message>(new Message("Registro correcto!", 
											Arrays.asList(returnedCustomer), ""), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Error registro de cliente!", 
											null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	//@GetMapping("/retrieveinfos")
	@GetMapping
	public ResponseEntity<Message> retrieveCustomerInfo() {
		
		try {
			List<Customer> customerInfos = customerServices.getCustomerInfos();
			
			return new ResponseEntity<Message>(new Message("Clientes!", 
												customerInfos, ""), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Error en listado de clientes!",
												null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@GetMapping("/findone/{id}")
	@GetMapping("/{id}")
	public ResponseEntity<Message> getCustomerById(@PathVariable long id) {
		try {
			Optional<Customer> optCustomer = customerServices.getCustomerById(id);
			
			if(optCustomer.isPresent()) {
				return new ResponseEntity<Message>(new Message("Datos de cliente = " + id,
															Arrays.asList(optCustomer.get()), ""), HttpStatus.OK);
			} else {
				return new ResponseEntity<Message>(new Message("No se encontro cliente con id = " + id,
						null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Error consulta de cliente",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@PutMapping("/updatebyid/{id}")
	@PutMapping("/{id}")
	public ResponseEntity<Message> updateCustomerById(@RequestBody Customer _customer, 
																	@PathVariable long id) {
		try {
			if(customerServices.checkExistedCustomer(id)) {
				Customer customer = customerServices.getCustomerById(id).get();
				
				customer.setFirstname(_customer.getFirstname());
				customer.setLastname(_customer.getLastname());
				customer.setAddress(customer.getAddress());
				customer.setAge(_customer.getAge());
	
				customerServices.updateCustomer(customer);
				
				return new ResponseEntity<Message>(new Message("Datos actualizados de cliente "
																		+ "con id = " + id,
																	Arrays.asList(customer), ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("NO se encuentra cliente"
						+ " con id = " + id,
					null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Error en la actualizacion",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	//@DeleteMapping("/deletebyid/{id}")
	@DeleteMapping("/{id}")
	public ResponseEntity<Message> deleteCustomerById(@PathVariable long id) {
		try {
			if(customerServices.checkExistedCustomer(id)) {
				customerServices.deleteCustomerById(id);
				
				return new ResponseEntity<Message> (new Message("Eliminacion de cliente con id = " + id, 
														null, ""), HttpStatus.OK);
			}else {
				return new ResponseEntity<Message>(new Message("No se encontro cliente "
														+ "con id = " + id, null, ""), HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<Message>(new Message("Error en eliminacion del cliente",
					null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}