package com.hampcode.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hampcode.model.domain.Customer;
import com.hampcode.pagination.PageRender;
import com.hampcode.service.impl.CustomerService;

@Controller
@SessionAttributes("customer")
@RequestMapping("/customers/")
@Secured("ROLE_ADMIN")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/list")
	public String getAllCustomers(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		try {
			Pageable pageRequest = PageRequest.of(page, 2);

			Page<Customer> customers = customerService.getAll(pageRequest);

			PageRender<Customer> pageRender = new PageRender<Customer>("/customers/list/", customers);

			model.addAttribute("title", "Clientes");

			model.addAttribute("customers", customers);
			model.addAttribute("page", pageRender);

		} catch (Exception e) {

		}

		return "customer/customer";
	}

	@GetMapping(value = "/new")
	public String newCustomer(Model model) {

		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		model.addAttribute("title", "Nuevo Cliente");
		return "customer/form";
	}

	@PostMapping(value = "/save")
	public String saveCustomer(@Valid Customer customer, BindingResult result, Model model, RedirectAttributes flash,
			SessionStatus status) {

		try {
			if (result.hasErrors()) {
				model.addAttribute("title", "Save Customer");
				return "customer/form";
			}

			String mensajeFlash = (customer.getId() != null) ? "Cliente editado correctamente!"
					: "Cliente registrado correctamente!";

			customerService.saveOrUpdate(customer);
			status.setComplete();
			flash.addFlashAttribute("success", mensajeFlash);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/customers/list";
	}

	@GetMapping(value = "/edit/{id}")
	public String editCustomer(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {

		Optional<Customer> customer = null;

		try {
			if (id > 0) {
				customer = customerService.getOne(id);
				if (!customer.isPresent()) {
					flash.addFlashAttribute("error", "El codigo del cliente no existe!");
					return "redirect:/customers/list";
				}
			} else {
				flash.addFlashAttribute("error", "El codigo del cliente no puede ser cero");
				return "redirect:/customers/list";
			}
			model.addAttribute("customer", customer);
			model.addAttribute("title", "Editar Cliente");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "customer/form";
	}
}
