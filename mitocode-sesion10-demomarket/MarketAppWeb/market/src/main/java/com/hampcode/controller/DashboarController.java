package com.hampcode.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboards/")
public class DashboarController {

	@GetMapping(value = "list")
	public String login() {
		return "dashboard/dashboard";
	}

}
