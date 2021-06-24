package com.hampcode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hampcode.model.domain.Invoice;
import com.hampcode.model.repository.InvoiceRepository;
import com.hampcode.service.IInvoiceService;

@Service
public class InvoiceService implements IInvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	@Transactional
	public Invoice saveOrUpdate(Invoice entity) {
		entity.getItems().forEach(item -> item.setInvoice(entity));
		return invoiceRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		invoiceRepository.deleteById(id);
	}

	@Override
	public Optional<Invoice> getOne(Long id) {
		return invoiceRepository.findById(id);
	}

	@Override
	public Optional<Invoice> getInvoiceByIdWithCustomerWhithInvoiceDetailWithProduct(Long invoiceId) {
		return invoiceRepository.findInvoiceByIdWithCustomerWhithItemInvoiceWithProduct(invoiceId);
	}

	@Override
	public List<Invoice> getAll() throws Exception {
		return invoiceRepository.findAll();
	}

	@Override
	public Page<Invoice> getAll(Pageable pageable) throws Exception {
		return null;
	}

	@Override
	public List<Invoice> findInvoicesByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return invoiceRepository.findInvoicesByCustomerId(customerId);
	}

}
