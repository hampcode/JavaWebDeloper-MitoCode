package com.hampcode.service;

import java.util.List;
import java.util.Optional;

import com.hampcode.model.domain.Invoice;

public interface IInvoiceService extends CrudService<Invoice> {
	Optional<Invoice> getInvoiceByIdWithCustomerWhithInvoiceDetailWithProduct(Long invoiceId) throws Exception;
	
	List<Invoice>findInvoicesByCustomerId(Long customerId);
}
